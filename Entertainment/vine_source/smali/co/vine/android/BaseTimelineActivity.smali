.class public abstract Lco/vine/android/BaseTimelineActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "BaseTimelineActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract getCurrentTimeLineFragment()Lco/vine/android/BaseTimelineFragment;
.end method

.method protected isAutoCaptureIconEnabled()Z
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x1

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 15
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 16
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineActivity;->getCurrentTimeLineFragment()Lco/vine/android/BaseTimelineFragment;

    move-result-object v0

    .line 17
    .local v0, "fragment":Lco/vine/android/BaseTimelineFragment;
    if-eqz v0, :cond_0

    .line 18
    invoke-virtual {v0}, Lco/vine/android/BaseTimelineFragment;->onBackPressed()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 24
    .end local v0    # "fragment":Lco/vine/android/BaseTimelineFragment;
    :goto_0
    return-void

    .line 23
    :cond_0
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onBackPressed()V

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 28
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineActivity;->isAutoCaptureIconEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-nez v0, :cond_0

    .line 29
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const/high16 v1, 0x7f100000

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 31
    :cond_0
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 36
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onPause()V

    .line 37
    invoke-static {p0}, Lco/vine/android/util/LoopManager;->get(Landroid/content/Context;)Lco/vine/android/util/LoopManager;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/util/LoopManager;->save()V

    .line 38
    return-void
.end method
