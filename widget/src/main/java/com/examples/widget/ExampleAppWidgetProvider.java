package com.examples.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;

import com.examples.widget.R;

public class ExampleAppWidgetProvider extends AppWidgetProvider {
    
    private static final String TAG = "ExampleAppWidgetProvider";

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
	Log.d(TAG, "onUpdate");

	final int N = appWidgetIds.length;

	// Perform this loop procedure for each App Widget that belongs to this provider 
	for (int i=0; i<N; i++) {
	    int appWidgetId = appWidgetIds[i];

	    // Create an intent to launch ExampleActivity
	    Intent intent = new Intent(context, ExampleActivity.class);
	    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

	    // Get the layout for the App Widget and attach an on-click listener
	    // to the button
	    RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.appwidget_provider_layout);
	    views.setOnClickPendingIntent(R.id.button, pendingIntent);

	    // Tell the AppWidgetManager to perform an update on the current app widget
	    appWidgetManager.updateAppWidget(appWidgetId, views);
	}
    }
}