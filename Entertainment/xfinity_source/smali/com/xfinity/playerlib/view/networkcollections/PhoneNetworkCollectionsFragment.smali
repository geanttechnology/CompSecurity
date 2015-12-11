.class public Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "PhoneNetworkCollectionsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;,
        Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;,
        Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;
    }
.end annotation


# instance fields
.field private actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

.field protected alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private bodyContainer:Landroid/view/View;

.field protected bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field private bundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

.field private categoryAdapter:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;

.field private categoryList:Landroid/widget/ListView;

.field private companyId:J

.field private final detailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private featureImage:Landroid/widget/ImageView;

.field private featureSection:Landroid/widget/LinearLayout;

.field private featureTitle:Landroid/widget/TextView;

.field private loadingIndicator:Landroid/view/View;

.field private showFilterButton:Z

.field private tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private tagsAndProgramsTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    .line 48
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createProgramDetailArtImageLoader()Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->detailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    .line 49
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsAndProgramsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 50
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->bundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    .line 51
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .line 52
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 54
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->tagsAndProgramsTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 212
    return-void
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryAdapter:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->showFilterButton:Z

    return v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryList:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->fetchData()V

    return-void
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)J
    .locals 2
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->companyId:J

    return-wide v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureImage:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureSection:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->detailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .prologue
    .line 46
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getOnClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnClickListener;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnLongClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .prologue
    .line 46
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getOnLongClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnLongClickListener;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureTitle:Landroid/widget/TextView;

    return-object v0
.end method

.method private fetchData()V
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->tagsAndProgramsTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 132
    return-void
.end method

.method private getOnClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnClickListener;
    .locals 1
    .param p1, "featuredShow"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .prologue
    .line 286
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;

    invoke-direct {v0, p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)V

    return-object v0
.end method

.method private getOnLongClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnLongClickListener;
    .locals 1
    .param p1, "featuredShow"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .prologue
    .line 301
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;

    invoke-direct {v0, p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)V

    return-object v0
.end method


# virtual methods
.method public hideLoading()V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->bodyContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 147
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->loadingIndicator:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 148
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    .line 75
    instance-of v0, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 76
    check-cast v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    .line 79
    :cond_0
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 81
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 85
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onCreate(Landroid/os/Bundle;)V

    .line 87
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 88
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 89
    .local v1, "intent":Landroid/content/Intent;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 90
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 93
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 94
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 97
    :cond_1
    const-string v2, "showFilterButton"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->showFilterButton:Z

    .line 98
    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->bundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    invoke-virtual {v2, v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;->getNetworkCompanyId(Landroid/os/Bundle;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->companyId:J

    .line 99
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 104
    sget v1, Lcom/xfinity/playerlib/R$layout;->network_collections_phone:I

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 106
    .local v0, "layout":Landroid/view/ViewGroup;
    sget v1, Lcom/xfinity/playerlib/R$id;->feature_section:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureSection:Landroid/widget/LinearLayout;

    .line 108
    sget v1, Lcom/xfinity/playerlib/R$id;->feature_image:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureImage:Landroid/widget/ImageView;

    .line 109
    sget v1, Lcom/xfinity/playerlib/R$id;->feature_title:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureTitle:Landroid/widget/TextView;

    .line 111
    sget v1, Lcom/xfinity/playerlib/R$id;->category_list:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryList:Landroid/widget/ListView;

    .line 112
    new-instance v1, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;

    invoke-direct {v1, p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Landroid/view/LayoutInflater;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryAdapter:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;

    .line 113
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryList:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryAdapter:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 115
    sget v1, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->loadingIndicator:Landroid/view/View;

    .line 116
    sget v1, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->bodyContainer:Landroid/view/View;

    .line 118
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    sget v2, Lcom/xfinity/playerlib/R$id;->touchy_parent:I

    invoke-interface {v1, v0, v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->setupPassiveGestureDetector(Landroid/view/View;I)V

    .line 119
    return-object v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 136
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onPause()V

    .line 137
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->tagsAndProgramsTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 138
    return-void
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 124
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onResumeInternal()V

    .line 126
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->showLoading()V

    .line 127
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->fetchData()V

    .line 128
    return-void
.end method

.method public showLoading()V
    .locals 2

    .prologue
    .line 141
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->bodyContainer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 142
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->loadingIndicator:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 143
    return-void
.end method
