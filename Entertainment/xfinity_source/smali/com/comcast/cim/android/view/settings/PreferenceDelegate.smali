.class public abstract Lcom/comcast/cim/android/view/settings/PreferenceDelegate;
.super Ljava/lang/Object;
.source "PreferenceDelegate.java"


# instance fields
.field private context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/android/view/settings/PreferenceDelegate;->context:Landroid/content/Context;

    .line 14
    return-void
.end method


# virtual methods
.method protected findPreference(I)Landroid/preference/Preference;
    .locals 1
    .param p1, "keyResource"    # I

    .prologue
    .line 23
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/PreferenceDelegate;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/view/settings/PreferenceDelegate;->findPreference(Ljava/lang/String;)Landroid/preference/Preference;

    move-result-object v0

    return-object v0
.end method

.method protected findPreference(Ljava/lang/String;)Landroid/preference/Preference;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/PreferenceDelegate;->getPrefFragment()Landroid/preference/PreferenceFragment;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/preference/PreferenceFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    return-object v0
.end method

.method protected getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/PreferenceDelegate;->context:Landroid/content/Context;

    return-object v0
.end method

.method protected abstract getPrefFragment()Landroid/preference/PreferenceFragment;
.end method
