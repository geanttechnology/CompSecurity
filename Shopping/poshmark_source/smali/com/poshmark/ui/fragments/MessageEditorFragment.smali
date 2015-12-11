.class public Lcom/poshmark/ui/fragments/MessageEditorFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "MessageEditorFragment.java"


# instance fields
.field defaultString:Ljava/lang/String;

.field private messageEditor:Lcom/poshmark/ui/customviews/PMEditText;

.field placeholderString:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/MessageEditorFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MessageEditorFragment;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->messageEditor:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method


# virtual methods
.method public handleBack()Z
    .locals 2

    .prologue
    .line 52
    const-string v0, "com.poshmark.intents.MESSAGE_EDITOR_ACTION_CANCELLED"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 53
    const/4 v0, 0x0

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 47
    const v0, 0x7f060034

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->setTitle(Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 27
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 28
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "PLACEHOLDER"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->placeholderString:Ljava/lang/String;

    .line 29
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "MESSAGE"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->defaultString:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 34
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 35
    const v1, 0x7f030081

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 36
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c0203

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->messageEditor:Lcom/poshmark/ui/customviews/PMEditText;

    .line 37
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->messageEditor:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->placeholderString:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setHint(Ljava/lang/CharSequence;)V

    .line 38
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->messageEditor:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->defaultString:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 39
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->messageEditor:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->requestFocus()Z

    .line 40
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->showKeyboard()V

    .line 41
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 3

    .prologue
    .line 85
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ANALYTICS_PAGE_NAME"

    const-string v2, "multiline_input_screen"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 86
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 58
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 59
    const v0, 0x7f0600bf

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;-><init>(Lcom/poshmark/ui/fragments/MessageEditorFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 82
    return-void
.end method
