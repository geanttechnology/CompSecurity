.class Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;
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
    .line 91
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;->this$0:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;->val$ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    iput-object p3, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;->val$preview:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 3
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 94
    move-object v0, p2

    check-cast v0, Ljava/lang/String;

    .line 95
    .local v0, "newValueString":Ljava/lang/String;
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 96
    .local v1, "value":I
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;->val$ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v2, v1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->setCCEdgeType(I)V

    move-object v2, p1

    .line 97
    check-cast v2, Landroid/preference/ListPreference;

    invoke-virtual {v2, v0}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    move-object v2, p1

    .line 98
    check-cast v2, Landroid/preference/ListPreference;

    invoke-virtual {v2}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 99
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;->val$preview:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->updatePreviewText()V

    .line 100
    const/4 v2, 0x0

    return v2
.end method
