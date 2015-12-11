.class public Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "KiangDebugSettingsActivity.java"


# instance fields
.field private mApplicationVersionEditText:Landroid/widget/EditText;

.field private mAssociateTagEditText:Landroid/widget/EditText;

.field private mHardwareIdentifierEditText:Landroid/widget/EditText;

.field private mOSVersionEditText:Landroid/widget/EditText;

.field private mUBIDEditText:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method private initSettings()V
    .locals 3

    .prologue
    .line 55
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 56
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    iget-object v1, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mUBIDEditText:Landroid/widget/EditText;

    const-string/jumbo v2, "Ubid"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 57
    iget-object v1, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mHardwareIdentifierEditText:Landroid/widget/EditText;

    const-string/jumbo v2, "hardwareIdentifier"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 58
    iget-object v1, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mOSVersionEditText:Landroid/widget/EditText;

    const-string/jumbo v2, "osVersion"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 59
    iget-object v1, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mApplicationVersionEditText:Landroid/widget/EditText;

    const-string/jumbo v2, "globalApplicationVersion"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 60
    iget-object v1, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mAssociateTagEditText:Landroid/widget/EditText;

    const-string/jumbo v2, "associatesTagCheckChange"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 61
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 30
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 31
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 32
    .local v1, "inflater":Landroid/view/LayoutInflater;
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->kiang_debug_settings:I

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 34
    .local v0, "content":Landroid/widget/LinearLayout;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->debug_kiang_ubid:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mUBIDEditText:Landroid/widget/EditText;

    .line 35
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->debug_kiang_hardwareIdentifier:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mHardwareIdentifierEditText:Landroid/widget/EditText;

    .line 36
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->debug_kiang_osversion:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mOSVersionEditText:Landroid/widget/EditText;

    .line 37
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->debug_kiang_applicationVersion:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mApplicationVersionEditText:Landroid/widget/EditText;

    .line 38
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->debug_kiang_associate:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mAssociateTagEditText:Landroid/widget/EditText;

    .line 40
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->kaing_save:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 41
    .local v2, "saveButton":Landroid/widget/Button;
    new-instance v3, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity$1;-><init>(Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    invoke-direct {p0}, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->initSettings()V

    .line 51
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->pushView(Landroid/view/View;)V

    .line 52
    return-void
.end method

.method protected saveDebugSettings()V
    .locals 3

    .prologue
    .line 64
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 66
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "Ubid"

    iget-object v2, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mUBIDEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    const-string/jumbo v1, "hardwareIdentifier"

    iget-object v2, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mHardwareIdentifierEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    const-string/jumbo v1, "osVersion"

    iget-object v2, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mOSVersionEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const-string/jumbo v1, "globalApplicationVersion"

    iget-object v2, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mApplicationVersionEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 70
    const-string/jumbo v1, "associatesTagCheckChange"

    iget-object v2, p0, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;->mAssociateTagEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    return-void
.end method
