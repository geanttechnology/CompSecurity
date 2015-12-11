.class public Lcom/amazon/mShop/gno/GNODebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "GNODebugSettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private mCollapseDuration:Landroid/widget/EditText;

.field private mExpandDuration:Landroid/widget/EditText;

.field private mSaveButton:Landroid/widget/Button;

.field private mUrlOverride:Landroid/widget/EditText;

.field private mUrlToast:Landroid/widget/CheckBox;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method public static getAnimationDurationMillis(Landroid/content/Context;Z)J
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "expand"    # Z

    .prologue
    .line 66
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    if-eqz p1, :cond_1

    const-string/jumbo v1, "GNOItem.ExpandDuration"

    :goto_0
    invoke-interface {v2, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getLong(Ljava/lang/String;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 68
    .local v0, "duration":Ljava/lang/Long;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-nez v1, :cond_0

    .line 69
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    if-eqz p1, :cond_2

    sget v1, Lcom/amazon/mShop/android/lib/R$integer;->animation_gno_expand_duration_per_item:I

    :goto_1
    invoke-virtual {v2, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    int-to-long v1, v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 72
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    return-wide v1

    .line 66
    .end local v0    # "duration":Ljava/lang/Long;
    :cond_1
    const-string/jumbo v1, "GNOItem.CollapseDuration"

    goto :goto_0

    .line 69
    .restart local v0    # "duration":Ljava/lang/Long;
    :cond_2
    sget v1, Lcom/amazon/mShop/android/lib/R$integer;->animation_gno_collapse_duration_per_item:I

    goto :goto_1
.end method

.method public static getTargetUrlOverride()Ljava/lang/String;
    .locals 3

    .prologue
    .line 119
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "GNODebugSettings.TargetUrlOverride"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getTargetUrlOverride(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "targetUrl"    # Ljava/lang/String;

    .prologue
    .line 102
    invoke-static {}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getTargetUrlOverride()Ljava/lang/String;

    move-result-object v3

    .line 104
    .local v3, "urlOverride":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 105
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 106
    .local v1, "uriOverride":Landroid/net/Uri;
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 107
    .local v0, "uri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v4

    invoke-virtual {v1}, Landroid/net/Uri;->getEncodedAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/net/Uri$Builder;->encodedAuthority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    invoke-virtual {v1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 115
    .end local v0    # "uri":Landroid/net/Uri;
    .end local v1    # "uriOverride":Landroid/net/Uri;
    .local v2, "url":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 112
    .end local v2    # "url":Ljava/lang/String;
    :cond_0
    move-object v2, p0

    .restart local v2    # "url":Ljava/lang/String;
    goto :goto_0
.end method

.method private init()V
    .locals 4

    .prologue
    .line 50
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mSaveButton:Landroid/widget/Button;

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 53
    invoke-static {}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getTargetUrlOverride()Ljava/lang/String;

    move-result-object v0

    .line 54
    .local v0, "targetUrlOverride":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 55
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mUrlOverride:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 59
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mUrlToast:Landroid/widget/CheckBox;

    invoke-static {}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->isUrlToastEnabled()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 61
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mExpandDuration:Landroid/widget/EditText;

    const/4 v2, 0x1

    invoke-static {p0, v2}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getAnimationDurationMillis(Landroid/content/Context;Z)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 62
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mCollapseDuration:Landroid/widget/EditText;

    const/4 v2, 0x0

    invoke-static {p0, v2}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getAnimationDurationMillis(Landroid/content/Context;Z)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 63
    return-void
.end method

.method public static isUrlToastEnabled()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 127
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "GNODebugSettings.TargetUrlToast"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method private setAnimationDurationMillis()V
    .locals 6

    .prologue
    .line 76
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mExpandDuration:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 77
    .local v1, "expandText":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mCollapseDuration:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 78
    .local v0, "collapseText":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 79
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "GNOItem.ExpandDuration"

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-interface {v2, v3, v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putLong(Ljava/lang/String;J)V

    .line 82
    :cond_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 83
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "GNOItem.CollapseDuration"

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-interface {v2, v3, v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putLong(Ljava/lang/String;J)V

    .line 85
    :cond_1
    return-void
.end method

.method private static setIsUrlToastEnabled(Ljava/lang/Boolean;)V
    .locals 3
    .param p0, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 131
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "GNODebugSettings.TargetUrlToast"

    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 132
    return-void
.end method

.method private static setTargetUrlOverride(Ljava/lang/String;)V
    .locals 3
    .param p0, "targetUrlOverride"    # Ljava/lang/String;

    .prologue
    .line 123
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "GNODebugSettings.TargetUrlOverride"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, p0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mUrlOverride:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->setTargetUrlOverride(Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mUrlToast:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->setIsUrlToastEnabled(Ljava/lang/Boolean;)V

    .line 91
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->setAnimationDurationMillis()V

    .line 93
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 94
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 34
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 36
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->gno_debug_settings:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->pushView(I)V

    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 40
    .local v0, "rootView":Landroid/view/View;
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->gno_debug_save:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mSaveButton:Landroid/widget/Button;

    .line 41
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->gno_debug_url_override:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mUrlOverride:Landroid/widget/EditText;

    .line 42
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->gno_debug_url_toast:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/CheckBox;

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mUrlToast:Landroid/widget/CheckBox;

    .line 43
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->gno_debug_anim_expand_duration:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mExpandDuration:Landroid/widget/EditText;

    .line 44
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->gno_debug_anim_collapse_duration:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->mCollapseDuration:Landroid/widget/EditText;

    .line 46
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->init()V

    .line 47
    return-void
.end method
