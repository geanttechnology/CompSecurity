.class public Lcom/poshmark/ui/fragments/CommentFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "CommentFragment.java"


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;

.field interactionsData:Lcom/poshmark/data_model/models/UserInteractions;

.field listingDetails:Lcom/poshmark/data_model/models/ListingSocial;

.field listingId:Ljava/lang/String;

.field replyToUserHandle:Ljava/lang/String;

.field textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/CommentFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CommentFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->updateAutoCompleteView()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/CommentFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CommentFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->postComment()V

    return-void
.end method

.method private postComment()V
    .locals 4

    .prologue
    .line 115
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CommentFragment;->textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 116
    .local v0, "comment":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-gtz v2, :cond_0

    .line 118
    const-string v2, ""

    const v3, 0x7f060030

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/CommentFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/poshmark/ui/fragments/CommentFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    :goto_0
    return-void

    .line 122
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060217

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/CommentFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 123
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-string v3, "cmt"

    invoke-static {v2, v3}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 125
    .local v1, "trackingJson":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CommentFragment;->listingId:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/ui/fragments/CommentFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/CommentFragment$2;-><init>(Lcom/poshmark/ui/fragments/CommentFragment;)V

    invoke-static {v2, v0, v1, v3}, Lcom/poshmark/http/api/PMApi;->postComment(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private setupActionBarNextActionButton()V
    .locals 2

    .prologue
    .line 200
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 201
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 211
    :goto_0
    return-void

    .line 204
    :cond_0
    const v1, 0x7f060216

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CommentFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 205
    new-instance v1, Lcom/poshmark/ui/fragments/CommentFragment$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CommentFragment$4;-><init>(Lcom/poshmark/ui/fragments/CommentFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private updateAutoCompleteView()V
    .locals 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->adapter:Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;

    new-instance v1, Lcom/poshmark/ui/fragments/CommentFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CommentFragment$3;-><init>(Lcom/poshmark/ui/fragments/CommentFragment;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;->setFilterQueryProvider(Landroid/widget/FilterQueryProvider;)V

    .line 196
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 85
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->interactionsData:Lcom/poshmark/data_model/models/UserInteractions;

    if-nez v0, :cond_0

    .line 87
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/CommentFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CommentFragment$1;-><init>(Lcom/poshmark/ui/fragments/CommentFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getUserInteractionsList(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 104
    :goto_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment;->adapter:Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 105
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;->setThreshold(I)V

    .line 106
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    const-string v1, " "

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;->setSeparator(Ljava/lang/String;)V

    .line 108
    return-void

    .line 101
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->updateAutoCompleteView()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 48
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 49
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ID"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->listingId:Ljava/lang/String;

    .line 50
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "REPLY_TO_HANDLE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->replyToUserHandle:Ljava/lang/String;

    .line 51
    const-class v0, Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CommentFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingSocial;

    .line 53
    new-instance v0, Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->adapter:Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;

    .line 54
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 58
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 59
    const v1, 0x7f030032

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 61
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c00dd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment;->textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    .line 62
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment;->replyToUserHandle:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 63
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment;->textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CommentFragment;->replyToUserHandle:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment;->textView:Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/MultiWordAutoCompleteView;->requestFocus()Z

    .line 69
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 71
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 111
    const-string v0, "add_comment_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 112
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 76
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 77
    const v0, 0x7f06008d

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CommentFragment;->setTitle(I)V

    .line 78
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CommentFragment;->setupActionBarNextActionButton()V

    .line 79
    return-void
.end method
