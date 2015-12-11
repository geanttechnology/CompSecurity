.class public Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;
.super Landroid/preference/PreferenceFragment;
.source "AuthenticatingPreferenceFragment.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private authenticatingActivity:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-class v0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Landroid/preference/PreferenceFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 15
    invoke-super {p0, p1}, Landroid/preference/PreferenceFragment;->onAttach(Landroid/app/Activity;)V

    .line 18
    :try_start_0
    check-cast p1, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->authenticatingActivity:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    .line 22
    return-void

    .line 19
    :catch_0
    move-exception v0

    .line 20
    .local v0, "e":Ljava/lang/ClassCastException;
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "AuthenticatingPreferenceFragment cannot be added to an activity that does not extend from AuthenticatingPreferenceFragment."

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public final onResume()V
    .locals 2

    .prologue
    .line 43
    invoke-super {p0}, Landroid/preference/PreferenceFragment;->onResume()V

    .line 44
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onResume"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 46
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->authenticatingActivity:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->isAuthenticated()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 47
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->onResumeInternal()V

    .line 49
    :cond_0
    return-void
.end method

.method protected onResumeInternal()V
    .locals 0

    .prologue
    .line 55
    return-void
.end method

.method public final onStart()V
    .locals 2

    .prologue
    .line 26
    invoke-super {p0}, Landroid/preference/PreferenceFragment;->onStart()V

    .line 27
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onStart"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 29
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->authenticatingActivity:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->isAuthenticated()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 30
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->onStartInternal()V

    .line 34
    :goto_0
    return-void

    .line 32
    :cond_0
    sget-object v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onStart() is a NOOP!"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onStartInternal()V
    .locals 0

    .prologue
    .line 40
    return-void
.end method
