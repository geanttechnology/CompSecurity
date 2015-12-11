.class public abstract Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;
.super Landroid/app/Activity;
.source "BrowseFilterDialog.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;


# static fields
.field protected static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private backButton:Landroid/view/View;

.field private bodyContainer:Landroid/view/View;

.field protected category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field private data:Landroid/content/Intent;

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private headerLabel:Landroid/widget/TextView;

.field protected isDualPanel:Z

.field private isInitializing:Z

.field private loadingIndicator:Landroid/view/View;

.field onBackStackChangedListener:Landroid/app/FragmentManager$OnBackStackChangedListener;

.field private orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

.field private pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

.field protected selectedCategory:Landroid/view/View;

.field public tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

.field private tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation
.end field

.field private tagsTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation
.end field

.field protected talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

.field talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

.field protected userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 45
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 46
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 47
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTalkDelegateFactory()Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    .line 48
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 61
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    .line 64
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isInitializing:Z

    .line 68
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 75
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 77
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->onBackStackChangedListener:Landroid/app/FragmentManager$OnBackStackChangedListener;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->backButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->headerLabel:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->handleBackButton()Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->hideLoading()V

    return-void
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    return-object v0
.end method

.method private handleBackButton()Z
    .locals 3

    .prologue
    .line 239
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    if-nez v1, :cond_1

    .line 240
    :cond_0
    const/4 v1, 0x1

    .line 248
    :goto_0
    return v1

    .line 242
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    .line 243
    .local v0, "browseFilterCategoryDetailPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
    if-eqz v0, :cond_2

    .line 244
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->unregisterOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 247
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->popBackStack()V

    .line 248
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private hideLoading()V
    .locals 2

    .prologue
    .line 231
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->loadingIndicator:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 232
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->bodyContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 233
    return-void
.end method

.method private showLoading()V
    .locals 2

    .prologue
    .line 226
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->loadingIndicator:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 227
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->bodyContainer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 228
    return-void
.end method

.method private turnOnTalkBackForAccessibility()V
    .locals 3

    .prologue
    .line 366
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 367
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-nez v0, :cond_0

    .line 368
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->getTalkDelegate(Landroid/app/Activity;Landroid/view/View;)Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    .line 371
    :cond_0
    return-void
.end method


# virtual methods
.method protected createBrowseFilterCategoriesPanel()Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    .locals 1

    .prologue
    .line 172
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->newInstance(Z)Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
.end method

.method protected abstract getGenres(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end method

.method public getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    return-object v0
.end method

.method protected getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 2

    .prologue
    .line 374
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    if-nez v0, :cond_0

    .line 375
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;-><init>(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 378
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    return-object v0
.end method

.method protected handleDone()V
    .locals 2

    .prologue
    .line 320
    const/4 v0, -0x1

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->data:Landroid/content/Intent;

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->setResult(ILandroid/content/Intent;)V

    .line 321
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->updateWith(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 322
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->finish()V

    .line 323
    return-void
.end method

.method public initialize()V
    .locals 2

    .prologue
    .line 271
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->showLoading()V

    .line 273
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 313
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 260
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->handleBackButton()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 261
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 263
    :cond_0
    return-void
.end method

.method public onCategoryChanged(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 7
    .param p1, "filterCategory"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    const/4 v6, 0x0

    .line 383
    .line 384
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    .line 386
    .local v0, "browseFilterCategoryDetailPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
    if-nez v0, :cond_5

    .line 387
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 388
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getGenres(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->newInstance(ZLjava/util/List;)Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    move-result-object v0

    .line 390
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-eqz v2, :cond_4

    .line 391
    sget v2, Lcom/xfinity/playerlib/R$id;->category_subpanel_fragment_container:I

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 392
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 402
    :cond_0
    :goto_0
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 416
    .end local v1    # "fragmentTransaction":Landroid/app/FragmentTransaction;
    :cond_1
    :goto_1
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-nez v2, :cond_2

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isInitializing:Z

    if-nez v2, :cond_3

    .line 417
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-virtual {v0, p0, v2, p1, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->changeCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)V

    .line 420
    :cond_3
    iput-boolean v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isInitializing:Z

    .line 421
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 422
    return-void

    .line 393
    .restart local v1    # "fragmentTransaction":Landroid/app/FragmentTransaction;
    :cond_4
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isInitializing:Z

    if-nez v2, :cond_0

    .line 394
    sget v2, Lcom/xfinity/playerlib/R$anim;->slide_in_right:I

    sget v3, Lcom/xfinity/playerlib/R$anim;->slide_out_left:I

    sget v4, Lcom/xfinity/playerlib/R$anim;->slide_in_left:I

    sget v5, Lcom/xfinity/playerlib/R$anim;->slide_out_right:I

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/app/FragmentTransaction;->setCustomAnimations(IIII)Landroid/app/FragmentTransaction;

    .line 395
    sget v2, Lcom/xfinity/playerlib/R$id;->categories_panel_fragment_container:I

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 396
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 398
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 399
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->backButton:Landroid/view/View;

    invoke-virtual {v2, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 404
    .end local v1    # "fragmentTransaction":Landroid/app/FragmentTransaction;
    :cond_5
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-virtual {v0, p0, v2, p1, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->changeCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)V

    .line 406
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-eqz v2, :cond_1

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isInitializing:Z

    if-eqz v2, :cond_1

    .line 409
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    .line 103
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 105
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v7

    invoke-interface {v7}, Lcom/comcast/cim/android/view/common/OrientationStrategy;->getAppropriateOrientation()I

    move-result v7

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->setRequestedOrientation(I)V

    .line 107
    new-instance v7, Landroid/content/Intent;

    invoke-direct {v7}, Landroid/content/Intent;-><init>()V

    iput-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->data:Landroid/content/Intent;

    .line 108
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->data:Landroid/content/Intent;

    const/high16 v8, 0x2000000

    invoke-virtual {v7, v8}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 110
    sget v7, Lcom/xfinity/playerlib/R$layout;->filter_dialog:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->setContentView(I)V

    .line 112
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v7}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v7

    if-nez v7, :cond_3

    .line 113
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$integer;->filter_dialog_panel_two_weight:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v7

    if-ne v7, v6, :cond_3

    :goto_0
    iput-boolean v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    .line 115
    if-eqz p1, :cond_0

    .line 116
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->processSavedInstanceState(Landroid/os/Bundle;)V

    .line 117
    const-string v6, "category"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-static {v6}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->int2FilterCategory(I)Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 119
    const-string v6, "pendingGenreFilters"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 120
    .local v4, "genreFilters":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v6, "pendingAlphaFilters"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 121
    .local v0, "alphaFilters":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v6, "pendingNetworkFilters"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v5

    check-cast v5, Ljava/util/HashMap;

    .line 123
    .local v5, "networkFilters":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 124
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->clearAllFilters()V

    .line 125
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentGenreFilters()Ljava/util/HashMap;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 126
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 127
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->pendingFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentAlphaFilters()Ljava/util/HashMap;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 130
    .end local v0    # "alphaFilters":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "genreFilters":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "networkFilters":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    sget v6, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->loadingIndicator:Landroid/view/View;

    .line 131
    sget v6, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->bodyContainer:Landroid/view/View;

    .line 133
    sget v6, Lcom/xfinity/playerlib/R$id;->header_label:I

    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    iput-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->headerLabel:Landroid/widget/TextView;

    .line 135
    iget-boolean v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-nez v6, :cond_1

    .line 136
    sget v6, Lcom/xfinity/playerlib/R$id;->back:I

    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->backButton:Landroid/view/View;

    .line 137
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->backButton:Landroid/view/View;

    new-instance v7, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$2;

    invoke-direct {v7, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 145
    :cond_1
    sget v6, Lcom/xfinity/playerlib/R$id;->apply:I

    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 146
    .local v1, "applyButton":Landroid/widget/Button;
    new-instance v6, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$3;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$3;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V

    invoke-virtual {v1, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 153
    sget v6, Lcom/xfinity/playerlib/R$id;->clearAll:I

    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 154
    .local v3, "clearAllButton":Landroid/widget/Button;
    new-instance v6, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$4;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$4;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V

    invoke-virtual {v3, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v6

    sget-object v7, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .line 163
    .local v2, "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    if-nez v2, :cond_2

    .line 164
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->createBrowseFilterCategoriesPanel()Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    move-result-object v2

    .line 165
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$id;->categories_panel_fragment_container:I

    sget-object v8, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v6, v7, v2, v8}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/FragmentTransaction;->commit()I

    .line 167
    :cond_2
    return-void

    .line 113
    .end local v1    # "applyButton":Landroid/widget/Button;
    .end local v2    # "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    .end local v3    # "clearAllButton":Landroid/widget/Button;
    :cond_3
    const/4 v6, 0x0

    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 357
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-eqz v0, :cond_0

    .line 358
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->onDestroy()V

    .line 361
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 362
    return-void
.end method

.method public onDownloadOnlyChanged(Z)V
    .locals 1
    .param p1, "downloadOnly"    # Z

    .prologue
    .line 432
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    .line 433
    .local v0, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setDownloadableOn(Z)V

    .line 434
    return-void
.end method

.method public onFilterItemDeselected(Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "filterCategory"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    .line 444
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    .line 445
    .local v0, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->removeFromSelectedList(Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 446
    return-void
.end method

.method public onFilterItemSelected(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;
    .param p3, "filterCategory"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    .line 438
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    .line 439
    .local v0, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    invoke-virtual {v0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->addToSelectedList(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 440
    return-void
.end method

.method protected onPause()V
    .locals 4

    .prologue
    .line 209
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 210
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 212
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .line 213
    .local v0, "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    if-eqz v0, :cond_0

    .line 214
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->unregisterOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 217
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    .line 218
    .local v1, "browseFilterCategoryDetailPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
    if-eqz v1, :cond_1

    .line 219
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->unregisterOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 222
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->onBackStackChangedListener:Landroid/app/FragmentManager$OnBackStackChangedListener;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->removeOnBackStackChangedListener(Landroid/app/FragmentManager$OnBackStackChangedListener;)V

    .line 223
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 186
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 188
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->turnOnTalkBackForAccessibility()V

    .line 190
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    if-nez v2, :cond_0

    .line 191
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->initialize()V

    .line 194
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->onBackStackChangedListener:Landroid/app/FragmentManager$OnBackStackChangedListener;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->addOnBackStackChangedListener(Landroid/app/FragmentManager$OnBackStackChangedListener;)V

    .line 196
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .line 197
    .local v0, "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->isVisible()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 198
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 201
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    .line 202
    .local v1, "browseFilterCategoryDetailPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->isVisible()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 203
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 205
    :cond_2
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 177
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 178
    const-string v0, "category"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ordinal()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 179
    const-string v0, "pendingGenreFilters"

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentGenreFilters()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 180
    const-string v0, "pendingAlphaFilters"

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentAlphaFilters()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 181
    const-string v0, "pendingNetworkFilters"

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 182
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 267
    const/4 v0, 0x0

    return v0
.end method

.method public onSubscriptionOnlyChanged(Z)V
    .locals 1
    .param p1, "subscriptionOnly"    # Z

    .prologue
    .line 426
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    .line 427
    .local v0, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setHideLockOn(Z)V

    .line 428
    return-void
.end method

.method protected abstract processSavedInstanceState(Landroid/os/Bundle;)V
.end method

.method protected resetFocus()V
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->headerLabel:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->requestFocus()Z

    .line 98
    return-void
.end method

.method protected setSelectedCategory(Landroid/view/View;)V
    .locals 2
    .param p1, "categoryView"    # Landroid/view/View;

    .prologue
    .line 328
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->selectedCategory:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 329
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->selectedCategory:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 332
    :cond_0
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->selectedCategory:Landroid/view/View;

    .line 334
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-eqz v0, :cond_1

    .line 335
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->selectedCategory:Landroid/view/View;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 337
    :cond_1
    return-void
.end method

.method protected speak(I)V
    .locals 1
    .param p1, "sayWhatResId"    # I

    .prologue
    .line 343
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-eqz v0, :cond_0

    .line 344
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->speak(Ljava/lang/String;)V

    .line 346
    :cond_0
    return-void
.end method

.method protected speak(Ljava/lang/String;)V
    .locals 1
    .param p1, "sayWhat"    # Ljava/lang/String;

    .prologue
    .line 350
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-eqz v0, :cond_0

    .line 351
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0, p1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 353
    :cond_0
    return-void
.end method
