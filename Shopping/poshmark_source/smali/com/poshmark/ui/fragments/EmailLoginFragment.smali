.class public Lcom/poshmark/ui/fragments/EmailLoginFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "EmailLoginFragment.java"


# static fields
.field public static final LOGIN_REQUEST_OK:I = 0x2


# instance fields
.field forgotPasswordButton:Landroid/widget/Button;

.field loginButton:Landroid/widget/Button;

.field passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field userHandleEditText:Lcom/poshmark/ui/customviews/PMEditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected isFormValid()Z
    .locals 3

    .prologue
    .line 150
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 151
    .local v0, "validateTxt":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->userHandleEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 152
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->userHandleEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 155
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    .line 156
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 159
    :cond_1
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 160
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060148

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    const/4 v1, 0x0

    .line 163
    :goto_0
    return v1

    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 62
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0105

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->userHandleEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 63
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0014

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 64
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    sget-object v1, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 65
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v1, Landroid/text/method/PasswordTransformationMethod;

    invoke-direct {v1}, Landroid/text/method/PasswordTransformationMethod;-><init>()V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMEditText;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 67
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0106

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->loginButton:Landroid/widget/Button;

    .line 68
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->loginButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/EmailLoginFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment$1;-><init>(Lcom/poshmark/ui/fragments/EmailLoginFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 76
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0107

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->forgotPasswordButton:Landroid/widget/Button;

    .line 77
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->forgotPasswordButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/EmailLoginFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment$2;-><init>(Lcom/poshmark/ui/fragments/EmailLoginFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 88
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 53
    const v1, 0x7f060194

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->setTitle(I)V

    .line 54
    const v1, 0x7f03003b

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 55
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method onLoginClicked()V
    .locals 9

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->isFormValid()Z

    move-result v6

    if-nez v6, :cond_0

    .line 147
    :goto_0
    return-void

    .line 100
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->hideKeyboard()V

    .line 102
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f060193

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 104
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 105
    .local v2, "hash":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/poshmark/utils/DeepLinkUtils;->getDeepLinkHash()Ljava/util/Map;

    move-result-object v0

    .line 106
    .local v0, "deepLinkMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v6

    if-lez v6, :cond_1

    .line 107
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->getView()Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v6

    check-cast v6, Landroid/app/Activity;

    invoke-static {v6}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingStackAsJson(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v5

    .line 108
    .local v5, "trackingJSON":Ljava/lang/String;
    const-string v6, "stack"

    invoke-virtual {v2, v6, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    new-instance v6, Lcom/google/gson/GsonBuilder;

    invoke-direct {v6}, Lcom/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v6}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 111
    .local v1, "gson":Lcom/google/gson/Gson;
    new-instance v6, Lcom/poshmark/ui/fragments/EmailLoginFragment$3;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment$3;-><init>(Lcom/poshmark/ui/fragments/EmailLoginFragment;)V

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/EmailLoginFragment$3;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 112
    .local v3, "hashMap":Ljava/lang/reflect/Type;
    instance-of v6, v1, Lcom/google/gson/Gson;

    if-nez v6, :cond_2

    invoke-virtual {v1, v0, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 113
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .local v4, "json":Ljava/lang/String;
    :goto_1
    const-string v6, "deeplinks"

    invoke-virtual {v2, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    .end local v3    # "hashMap":Ljava/lang/reflect/Type;
    .end local v4    # "json":Ljava/lang/String;
    .end local v5    # "trackingJSON":Ljava/lang/String;
    :cond_1
    iget-object v6, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->userHandleEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v6}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v7}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;-><init>(Lcom/poshmark/ui/fragments/EmailLoginFragment;)V

    invoke-static {v6, v7, v2, v8}, Lcom/poshmark/http/api/PMApi;->pmLogin(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 112
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "hashMap":Ljava/lang/reflect/Type;
    .restart local v5    # "trackingJSON":Ljava/lang/String;
    :cond_2
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    goto :goto_1
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 91
    const-string v0, "email_login_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 92
    return-void
.end method
