package vn.icar.rim.device.entitiy;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class AppInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Context context;
    private PackageInfo packageInfo;
    private CharSequence title;
    private Drawable drawable;
    private Drawable sDrawable;
    private Drawable bDrawable;

    public AppInfo(Context context, PackageInfo packageInfo) {

        this.context = context;
        this.packageInfo = packageInfo;
        this.title = context.getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
        this.drawable = context.getPackageManager().getApplicationIcon(packageInfo.applicationInfo);
    }

    public PackageInfo getPackageInfo() {

        return packageInfo;
    }

    public CharSequence getTitle() {

        return title;
    }

    public Drawable getSDrawable() {

        if (drawable != null && sDrawable == null) {
            Bitmap bitmap;
            try {
                bitmap = ((BitmapDrawable) ((StateListDrawable) drawable).getCurrent()).getBitmap();
            } catch (Exception e) {
                bitmap = getBitmapFromDrawable(drawable);
            }
            sDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, 24, 24, true));
        }

        return sDrawable;
    }

    public Drawable getBDrawable() {

        if (drawable != null && bDrawable == null) {
            Bitmap bitmap;
            try {
                bitmap = ((BitmapDrawable) ((StateListDrawable) drawable).getCurrent()).getBitmap();
            } catch (Exception e) {
                bitmap = getBitmapFromDrawable(drawable);
            }
            bDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, 56, 56, true));
        }

        return bDrawable;
    }
    @NonNull
    static private Bitmap getBitmapFromDrawable(@NonNull Drawable drawable) {
        final Bitmap bmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bmp);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bmp;
    }
}
