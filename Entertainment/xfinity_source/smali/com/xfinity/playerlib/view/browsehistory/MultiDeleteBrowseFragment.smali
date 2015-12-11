.class public abstract Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;
.super Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;
.source "MultiDeleteBrowseFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/ScrollStateTracker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Ljava/lang/Object;",
        "T:",
        "Ljava/lang/Object;",
        "A:",
        "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter",
        "<TT;*>;>",
        "Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;",
        "Lcom/xfinity/playerlib/view/ScrollStateTracker;"
    }
.end annotation


# static fields
.field public static EXTRA_BABY_GUIDE_MODE:Ljava/lang/String;


# instance fields
.field private absListView:Landroid/widget/AbsListView;

.field protected adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TA;"
        }
    .end annotation
.end field

.field protected alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private bodyContainer:Landroid/view/ViewGroup;

.field private checkedItemPositionsToRestore:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field protected currentlyPlayingVideoId:Ljava/lang/Long;

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field protected inBabyGuideMode:Z

.field private layoutInflator:Landroid/view/LayoutInflater;

.field private loadingIndicator:Landroid/view/ViewGroup;

.field private noContentMessage:Landroid/widget/TextView;

.field private scrollState:I

.field private taskExecutionListener:Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener",
            "<TD;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-string v0, "babyGuideMode"

    sput-object v0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->EXTRA_BABY_GUIDE_MODE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;-><init>()V

    .line 32
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 47
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->checkedItemPositionsToRestore:Ljava/util/ArrayList;

    .line 351
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->isEditMode:Z

    return v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->checkedItemPositionsToRestore:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$1002(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;
    .param p1, "x1"    # I

    .prologue
    .line 30
    iput p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->scrollState:I

    return p1
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Landroid/widget/AbsListView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showSelectedCountOnActionMenu()V

    return-void
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->isEditMode:Z

    return v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->startActionMode()V

    return-void
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;
    .param p1, "x1"    # I

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->toggleItem(I)V

    return-void
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->isEditMode:Z

    return v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->uncheckAll()V

    return-void
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showSelectedCountOnActionMenu()V

    return-void
.end method

.method private getCheckedItemPositions()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 321
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    invoke-virtual {v3}, Landroid/widget/AbsListView;->getCheckedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v2

    .line 322
    .local v2, "sba":Landroid/util/SparseBooleanArray;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 324
    .local v0, "checkedItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v2}, Landroid/util/SparseBooleanArray;->size()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 325
    invoke-virtual {v2, v1}, Landroid/util/SparseBooleanArray;->valueAt(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 326
    invoke-virtual {v2, v1}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 324
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 329
    :cond_1
    return-object v0
.end method

.method private hideNoContentMessage()V
    .locals 2

    .prologue
    .line 361
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->noContentMessage:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 362
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->bodyContainer:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->safeSetVisibility(Landroid/view/View;I)V

    .line 363
    return-void
.end method

.method private showNoContentMessage()V
    .locals 2

    .prologue
    .line 356
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->noContentMessage:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 357
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->bodyContainer:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->safeSetVisibility(Landroid/view/View;I)V

    .line 358
    return-void
.end method

.method private toggleItem(I)V
    .locals 4
    .param p1, "position"    # I

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    const/4 v1, 0x0

    .line 243
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    invoke-virtual {v2}, Landroid/widget/AbsListView;->getCheckedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v0

    .line 244
    .local v0, "sba":Landroid/util/SparseBooleanArray;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v3

    if-nez v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    invoke-virtual {v2, p1, v1}, Landroid/widget/AbsListView;->setItemChecked(IZ)V

    .line 246
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showSelectedCountOnActionMenu()V

    .line 248
    return-void
.end method

.method private uncheckAll()V
    .locals 3

    .prologue
    .line 260
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    invoke-virtual {v1}, Landroid/widget/AbsListView;->getCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 261
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/widget/AbsListView;->setItemChecked(IZ)V

    .line 260
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 263
    :cond_0
    return-void
.end method


# virtual methods
.method protected abstract createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/LayoutInflater;",
            ")TA;"
        }
    .end annotation
.end method

.method protected abstract deleteItem(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method protected deleteItems()V
    .locals 12

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    const/4 v11, 0x0

    .line 286
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getCheckedItemPositions()Ljava/util/ArrayList;

    move-result-object v0

    .line 287
    .local v0, "checkedPositions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v4

    .line 288
    .local v4, "itemsToRemove":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getListView()Landroid/widget/AbsListView;

    move-result-object v5

    .line 289
    .local v5, "listView":Landroid/widget/AbsListView;
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 290
    .local v1, "i":Ljava/lang/Integer;
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-virtual {v5, v8}, Landroid/widget/AbsListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v8

    invoke-static {v8}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 291
    .local v2, "item":Ljava/lang/Object;, "TT;"
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-virtual {v5, v8, v11}, Landroid/widget/AbsListView;->setItemChecked(IZ)V

    .line 292
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->deleteItem(Ljava/lang/Object;)V

    .line 293
    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 296
    .end local v1    # "i":Ljava/lang/Integer;
    .end local v2    # "item":Ljava/lang/Object;, "TT;"
    :cond_0
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    invoke-virtual {v7, v4}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->removeItems(Ljava/util/List;)V

    .line 298
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v3

    .line 299
    .local v3, "itemsRemovedCount":I
    if-lez v3, :cond_1

    .line 300
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getActivity()Landroid/app/Activity;

    move-result-object v7

    invoke-virtual {v7}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$plurals;->items_removed:I

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v11

    invoke-virtual {v7, v8, v3, v9}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 301
    .local v6, "toastText":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getActivity()Landroid/app/Activity;

    move-result-object v7

    invoke-static {v7, v6, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/Toast;->show()V

    .line 302
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v7}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v7

    invoke-interface {v7, v6}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 305
    .end local v6    # "toastText":Ljava/lang/String;
    :cond_1
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->getData()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-nez v7, :cond_2

    .line 306
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showNoContentMessage()V

    .line 308
    :cond_2
    return-void
.end method

.method protected getCheckedItemsCount()I
    .locals 1

    .prologue
    .line 317
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getCheckedItemPositions()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method protected abstract getData(Ljava/lang/Object;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end method

.method protected abstract getDataTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TD;>;"
        }
    .end annotation
.end method

.method protected abstract getItemClickListener()Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener",
            "<TT;>;"
        }
    .end annotation
.end method

.method protected abstract getListHeaderText()Ljava/lang/CharSequence;
.end method

.method public getListView()Landroid/widget/AbsListView;
    .locals 1

    .prologue
    .line 280
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    return-object v0
.end method

.method protected abstract getListViewId()I
.end method

.method protected getTotalItemsCount()I
    .locals 1

    .prologue
    .line 312
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->getCount()I

    move-result v0

    return v0
.end method

.method protected hideLoading()V
    .locals 2

    .prologue
    .line 273
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->loadingIndicator:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->bodyContainer:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 274
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->loadingIndicator:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 275
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->bodyContainer:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 277
    :cond_0
    return-void
.end method

.method protected isEditEnabled()Z
    .locals 1

    .prologue
    .line 334
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->inBabyGuideMode:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFlinging()Z
    .locals 2

    .prologue
    .line 234
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->scrollState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 91
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onAttach(Landroid/app/Activity;)V

    .line 92
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 93
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    const-wide/16 v6, 0x0

    .line 55
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->layoutInflator:Landroid/view/LayoutInflater;

    .line 57
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 58
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 60
    .local v1, "intent":Landroid/content/Intent;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 61
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 64
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 65
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 68
    :cond_1
    sget-object v3, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->EXTRA_BABY_GUIDE_MODE:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->inBabyGuideMode:Z

    .line 70
    const-string v3, "EXTRA_CURRENT_WATCH_VIDEO_ID"

    invoke-virtual {v0, v3, v6, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 71
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->currentlyPlayingVideoId:Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-nez v3, :cond_3

    const/4 v3, 0x0

    :goto_0
    iput-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 73
    if-eqz p3, :cond_2

    const-string v3, "previouslyCheckedItemPositions"

    invoke-virtual {p3, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 74
    const-string v3, "previouslyCheckedItemPositions"

    invoke-virtual {p3, v3}, Landroid/os/Bundle;->getIntegerArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->checkedItemPositionsToRestore:Ljava/util/ArrayList;

    .line 77
    :cond_2
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v2

    .line 79
    .local v2, "view":Landroid/view/View;
    sget v3, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->loadingIndicator:Landroid/view/ViewGroup;

    .line 80
    sget v3, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->bodyContainer:Landroid/view/ViewGroup;

    .line 82
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getListViewId()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/AbsListView;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    .line 83
    sget v3, Lcom/xfinity/playerlib/R$id;->no_content_message:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->noContentMessage:Landroid/widget/TextView;

    .line 84
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->setupListView(Landroid/widget/AbsListView;)V

    .line 86
    return-object v2

    .line 71
    .end local v2    # "view":Landroid/view/View;
    :cond_3
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->currentlyPlayingVideoId:Ljava/lang/Long;

    goto :goto_0
.end method

.method protected onEditModeChanged(Z)V
    .locals 1
    .param p1, "isEditMode"    # Z

    .prologue
    .line 251
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    if-nez p1, :cond_0

    .line 252
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->uncheckAll()V

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->setEditMode(Z)V

    .line 256
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 150
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    invoke-super {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onPause()V

    .line 151
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getCheckedItemPositions()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->checkedItemPositionsToRestore:Ljava/util/ArrayList;

    .line 153
    return-void
.end method

.method protected onResourceFetched(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 133
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    .local p1, "data":Ljava/lang/Object;, "TD;"
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getData(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->setData(Ljava/util/List;)V

    .line 134
    return-void
.end method

.method public onResumeInternal()V
    .locals 6

    .prologue
    .line 97
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    invoke-super {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onResumeInternal()V

    .line 99
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showLoading()V

    .line 101
    new-instance v5, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;-><init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    .line 108
    .local v5, "cancelListener":Landroid/content/DialogInterface$OnCancelListener;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getDataTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    .line 109
    .local v2, "dataTaskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TD;>;"
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;-><init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    invoke-interface {v2, v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->taskExecutionListener:Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    .line 130
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 163
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 164
    const-string v0, "previouslyCheckedItemPositions"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->checkedItemPositionsToRestore:Ljava/util/ArrayList;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putIntegerArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 165
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 157
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    invoke-super {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onStop()V

    .line 158
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getDataTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->taskExecutionListener:Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 159
    return-void
.end method

.method protected setData(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 137
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->hideLoading()V

    .line 139
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 140
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->hideNoContentMessage()V

    .line 141
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->setData(Ljava/util/List;)V

    .line 142
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->notifyDataSetChanged()V

    .line 146
    :goto_0
    return-void

    .line 144
    :cond_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showNoContentMessage()V

    goto :goto_0
.end method

.method protected setupListView(Landroid/widget/AbsListView;)V
    .locals 1
    .param p1, "absListView"    # Landroid/widget/AbsListView;

    .prologue
    .line 168
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setChoiceMode(I)V

    .line 170
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->inBabyGuideMode:Z

    if-nez v0, :cond_0

    .line 173
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;-><init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 190
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->layoutInflator:Landroid/view/LayoutInflater;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    .line 191
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 193
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;-><init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 218
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;-><init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 230
    return-void
.end method

.method protected showLoading()V
    .locals 2

    .prologue
    .line 266
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment<TD;TT;TA;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->loadingIndicator:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->bodyContainer:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 267
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->loadingIndicator:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 268
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->bodyContainer:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 270
    :cond_0
    return-void
.end method
