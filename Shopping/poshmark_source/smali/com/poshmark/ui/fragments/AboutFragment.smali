.class public Lcom/poshmark/ui/fragments/AboutFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "AboutFragment.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/AboutFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/AboutFragment;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/AboutFragment;->launchUrl(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private launchUrl(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "analyticsPageName"    # Ljava/lang/String;

    .prologue
    .line 78
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 79
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AboutFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 82
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 83
    return-void
.end method

.method private setupButtons()V
    .locals 7

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AboutFragment;->getView()Landroid/view/View;

    move-result-object v5

    const v6, 0x7f0c002b

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 42
    .local v2, "termsConditions":Landroid/widget/Button;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AboutFragment;->getView()Landroid/view/View;

    move-result-object v5

    const v6, 0x7f0c002c

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 43
    .local v1, "privacyPolicy":Landroid/widget/Button;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AboutFragment;->getView()Landroid/view/View;

    move-result-object v5

    const v6, 0x7f0c002d

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 44
    .local v0, "libraries":Landroid/widget/Button;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AboutFragment;->getView()Landroid/view/View;

    move-result-object v5

    const v6, 0x7f0c002e

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    .line 46
    .local v4, "versionTextView":Lcom/poshmark/ui/customviews/PMTextView;
    const v5, 0x7f060298

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setText(I)V

    .line 47
    const v5, 0x7f06021d

    invoke-virtual {v1, v5}, Landroid/widget/Button;->setText(I)V

    .line 48
    const v5, 0x7f060162

    invoke-virtual {v0, v5}, Landroid/widget/Button;->setText(I)V

    .line 51
    new-instance v5, Lcom/poshmark/ui/fragments/AboutFragment$1;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/AboutFragment$1;-><init>(Lcom/poshmark/ui/fragments/AboutFragment;)V

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    new-instance v5, Lcom/poshmark/ui/fragments/AboutFragment$2;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/AboutFragment$2;-><init>(Lcom/poshmark/ui/fragments/AboutFragment;)V

    invoke-virtual {v1, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    new-instance v5, Lcom/poshmark/ui/fragments/AboutFragment$3;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/AboutFragment$3;-><init>(Lcom/poshmark/ui/fragments/AboutFragment;)V

    invoke-virtual {v0, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "v"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v6

    iget-object v6, v6, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 74
    .local v3, "version":Ljava/lang/String;
    invoke-virtual {v4, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 75
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 32
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 33
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/AboutFragment;->setupButtons()V

    .line 34
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 23
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 25
    const v1, 0x7f06002c

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/AboutFragment;->setTitle(I)V

    .line 26
    const/high16 v1, 0x7f030000

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 27
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 37
    const-string v0, "about_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AboutFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 38
    return-void
.end method
