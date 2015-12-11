.class public abstract Lco/vine/android/BaseControllerActionBarActivity;
.super Lco/vine/android/BaseActionBarActivity;
.source "BaseControllerActionBarActivity.java"

# interfaces
.implements Lco/vine/android/ScrollListener;


# static fields
.field public static final EXTRA_TITLE_ID:Ljava/lang/String; = "title"


# instance fields
.field protected mAppController:Lco/vine/android/client/AppController;

.field protected mAppSessionListener:Lco/vine/android/client/AppSessionListener;

.field private mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lco/vine/android/BaseActionBarActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected createSlidingMenuHelper()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lco/vine/android/util/ConversationMenuHelper;

    invoke-direct {v0, p0}, Lco/vine/android/util/ConversationMenuHelper;-><init>(Lco/vine/android/BaseControllerActionBarActivity;)V

    iput-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    .line 81
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    return-object v0
.end method

.method public getAppController()Lco/vine/android/client/AppController;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppController:Lco/vine/android/client/AppController;

    return-object v0
.end method

.method public getConversationSlidingMenuHelper()Lco/vine/android/util/ConversationMenuHelper;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    return-object v0
.end method

.method public isConversationSideMenuEnabled()Z
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x0

    return v0
.end method

.method protected isSlidingMenuEnabled()Z
    .locals 1

    .prologue
    .line 90
    invoke-virtual {p0}, Lco/vine/android/BaseControllerActionBarActivity;->isConversationSideMenuEnabled()Z

    move-result v0

    return v0
.end method

.method public notifyColorChange(I)V
    .locals 1
    .param p1, "profileBackground"    # I

    .prologue
    .line 98
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/util/ConversationMenuHelper;->setPersonalizedColor(I)V

    .line 101
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;IZ)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .param p2, "layout"    # I
    .param p3, "loginRequired"    # Z

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZZ)V

    .line 27
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;IZZ)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .param p2, "layout"    # I
    .param p3, "loginRequired"    # Z
    .param p4, "readOnly"    # Z

    .prologue
    .line 30
    invoke-super {p0, p1, p2, p3, p4}, Lco/vine/android/BaseActionBarActivity;->onCreate(Landroid/os/Bundle;IZZ)V

    .line 32
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppController:Lco/vine/android/client/AppController;

    .line 34
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    invoke-virtual {v0}, Lco/vine/android/util/ConversationMenuHelper;->setupConversationSlidingMenu()V

    .line 37
    :cond_0
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 46
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onDestroy()V

    .line 47
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-nez v0, :cond_0

    .line 48
    invoke-static {}, Lco/vine/android/player/SdkVideoView;->releaseStaticIfNeeded()V

    .line 50
    :cond_0
    return-void
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 65
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onPause()V

    .line 66
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    invoke-virtual {v0}, Lco/vine/android/util/ConversationMenuHelper;->onPause()V

    .line 69
    :cond_0
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    if-eqz v0, :cond_1

    .line 70
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->removeListener(Lco/vine/android/client/AppSessionListener;)V

    .line 72
    :cond_1
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 54
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onResume()V

    .line 55
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mConversationSlidingMenuHelper:Lco/vine/android/util/ConversationMenuHelper;

    invoke-virtual {v0}, Lco/vine/android/util/ConversationMenuHelper;->onResume()V

    .line 58
    :cond_0
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    if-eqz v0, :cond_1

    .line 59
    iget-object v0, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/BaseControllerActionBarActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->addListener(Lco/vine/android/client/AppSessionListener;)V

    .line 61
    :cond_1
    return-void
.end method

.method public onScroll(I)V
    .locals 0
    .param p1, "delta"    # I

    .prologue
    .line 42
    return-void
.end method
