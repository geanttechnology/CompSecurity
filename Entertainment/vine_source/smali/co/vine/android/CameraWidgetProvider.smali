.class public Lco/vine/android/CameraWidgetProvider;
.super Landroid/appwidget/AppWidgetProvider;
.source "CameraWidgetProvider.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/appwidget/AppWidgetProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public onDeleted(Landroid/content/Context;[I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appWidgetIds"    # [I

    .prologue
    .line 33
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackCameraWidgetRemoved()V

    .line 34
    return-void
.end method

.method public onUpdate(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appWidgetManager"    # Landroid/appwidget/AppWidgetManager;
    .param p3, "appWidgetIds"    # [I

    .prologue
    const/4 v9, 0x0

    .line 20
    new-instance v6, Landroid/widget/RemoteViews;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    const v8, 0x7f030022

    invoke-direct {v6, v7, v8}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 21
    .local v6, "views":Landroid/widget/RemoteViews;
    move-object v0, p3

    .local v0, "arr$":[I
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_0

    aget v2, v0, v1

    .line 22
    .local v2, "id":I
    const/4 v7, -0x1

    const-string v8, "CameraWidget"

    invoke-static {p1, v7, v8}, Lco/vine/android/AbstractRecordingActivity;->getIntentForGeneric(Landroid/content/Context;ILjava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 23
    .local v3, "intent":Landroid/content/Intent;
    const-string v7, "co.vine.android.RECORD"

    invoke-virtual {v3, v7}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 24
    invoke-static {p1, v9, v3, v9}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v5

    .line 25
    .local v5, "pendingIntent":Landroid/app/PendingIntent;
    const v7, 0x7f0a0076

    invoke-virtual {v6, v7, v5}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 26
    invoke-virtual {p2, v2, v6}, Landroid/appwidget/AppWidgetManager;->updateAppWidget(ILandroid/widget/RemoteViews;)V

    .line 21
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 28
    .end local v2    # "id":I
    .end local v3    # "intent":Landroid/content/Intent;
    .end local v5    # "pendingIntent":Landroid/app/PendingIntent;
    :cond_0
    new-instance v7, Landroid/content/Intent;

    const-class v8, Lco/vine/android/service/ResourceService;

    invoke-direct {v7, p1, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p1, v7}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 29
    return-void
.end method
