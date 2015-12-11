.class Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;
.super Ljava/lang/Object;
.source "CCPreferenceDelegate.java"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->setupPreferences(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Landroid/preference/PreferenceScreen;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;

.field final synthetic val$ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

.field final synthetic val$preview:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;->this$0:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;->val$ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    iput-object p3, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;->val$preview:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 2
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 77
    check-cast p2, Ljava/lang/String;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 78
    .local v0, "value":I
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;->val$ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v1, v0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->setCCTextColor(I)V

    move-object v1, p1

    .line 79
    check-cast v1, Landroid/preference/ListPreference;

    invoke-virtual {v1, v0}, Landroid/preference/ListPreference;->setValueIndex(I)V

    move-object v1, p1

    .line 80
    check-cast v1, Landroid/preference/ListPreference;

    invoke-virtual {v1}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 81
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;->val$preview:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->updatePreviewText()V

    .line 82
    const/4 v1, 0x0

    return v1
.end method
