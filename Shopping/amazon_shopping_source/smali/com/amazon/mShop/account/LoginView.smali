.class public Lcom/amazon/mShop/account/LoginView;
.super Landroid/widget/ScrollView;
.source "LoginView.java"

# interfaces
.implements Lcom/amazon/mShop/DelayedInitView;
.implements Lcom/amazon/mShop/TitleProvider;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 24
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->login:I

    const/4 v3, 0x0

    invoke-static {p1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 25
    .local v0, "content":Landroid/view/View;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->login_password_edit:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 28
    .local v1, "passwordEditText":Landroid/widget/EditText;
    sget-object v2, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 30
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LoginView;->addView(Landroid/view/View;)V

    .line 32
    return-void
.end method

.method private updateSoftKeyboard()V
    .locals 2

    .prologue
    .line 47
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->login_password_edit:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/account/LoginView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 48
    .local v0, "loginPasswordEditText":Landroid/widget/EditText;
    invoke-virtual {v0}, Landroid/widget/EditText;->isFocused()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 49
    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->showSoftKeyboard(Landroid/view/View;)V

    .line 51
    :cond_0
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 55
    invoke-super {p0}, Landroid/widget/ScrollView;->onDetachedFromWindow()V

    .line 56
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/account/LoginActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/LoginActivity;->hasSignedIn()Z

    move-result v0

    if-nez v0, :cond_0

    .line 57
    const-string/jumbo v0, "si_not_done"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 59
    :cond_0
    return-void
.end method

.method public onPushViewCompleted()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginView;->updateSoftKeyboard()V

    .line 44
    return-void
.end method
