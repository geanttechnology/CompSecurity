.class public abstract Lcom/xfinity/playerlib/view/PlayNowActivity;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;
.source "PlayNowActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/PlayNowActivity$PlayNowActivitySpeechListener;
    }
.end annotation


# instance fields
.field protected androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private appirater:Lcom/ijsbrandslob/appirater/Appirater;

.field protected userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;-><init>()V

    .line 19
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PlayNowActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 20
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PlayNowActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 21
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAppirater()Lcom/ijsbrandslob/appirater/Appirater;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PlayNowActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    .line 63
    return-void
.end method


# virtual methods
.method protected addDefaultActivitySpeechListener()V
    .locals 1

    .prologue
    .line 60
    new-instance v0, Lcom/xfinity/playerlib/view/PlayNowActivity$PlayNowActivitySpeechListener;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/PlayNowActivity$PlayNowActivitySpeechListener;-><init>(Lcom/xfinity/playerlib/view/PlayNowActivity;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/PlayNowActivity;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 61
    return-void
.end method

.method protected abstract getLayoutId()I
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    return-object v0
.end method

.method protected getUserManager()Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/UserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PlayNowActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/PlayNowActivity;->setupTalkDelegateForAccessibilityViaLayout()V

    .line 28
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onCreate(Landroid/os/Bundle;)V

    .line 29
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/PlayNowActivity;->getLayoutId()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/PlayNowActivity;->setContentView(I)V

    .line 30
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 41
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onPause()V

    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PlayNowActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    invoke-virtual {v0}, Lcom/ijsbrandslob/appirater/Appirater;->dismiss()V

    .line 44
    return-void
.end method

.method public onResumeInternal()V
    .locals 2

    .prologue
    .line 34
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onResumeInternal()V

    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PlayNowActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p0}, Lcom/ijsbrandslob/appirater/Appirater;->appEnteredForeground(ZLandroid/app/Activity;)V

    .line 37
    return-void
.end method
