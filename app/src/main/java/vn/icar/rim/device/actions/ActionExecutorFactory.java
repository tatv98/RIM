package vn.icar.rim.device.actions;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import vn.icar.rim.device.actions.executors.ActionExecutor;
import vn.icar.rim.device.actions.executors.AppExecutor;
import vn.icar.rim.device.actions.executors.MediaExecutor;
import vn.icar.rim.device.actions.executors.TaskExecutor;
import vn.icar.rim.device.actions.executors.VolumeExecutor;

@EBean
public class ActionExecutorFactory {

    @RootContext Context context;

    public ActionExecutor getExecutor(ActionExecutor.ActionType type) {

        switch (type) {
            case APP:
                return new AppExecutor(context);
            case TASKER:
                return new TaskExecutor(context);
            case VOLUME:
                return new VolumeExecutor(context);
            case MEDIA:
                return new MediaExecutor(context);
            default:
                return null;
        }
    }

}
