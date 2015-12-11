.class public Lcom/mixerbox/mixerbox3b/fragments/SortFragment;
.super Landroid/support/v4/app/ListFragment;
.source "SourceFile"


# instance fields
.field adapter:Lcom/mixerbox/mixerbox3b/adapters/SortAdapter;

.field public array:Ljava/util/ArrayList;

.field public ctx:Landroid/content/Context;

.field public dragEnabled:Z

.field public dragStartMode:I

.field private mController:Lcom/mobeta/android/dslv/c;

.field private mDslv:Lcom/mobeta/android/dslv/DragSortListView;

.field private onDrop:Lcom/mobeta/android/dslv/i;

.field public pid:Ljava/lang/String;

.field public sortEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 18
    invoke-direct {p0}, Landroid/support/v4/app/ListFragment;-><init>()V

    .line 28
    const/4 v0, 0x0

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->dragStartMode:I

    .line 29
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->sortEnabled:Z

    .line 30
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->dragEnabled:Z

    .line 76
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SortFragment;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->onDrop:Lcom/mobeta/android/dslv/i;

    return-void
.end method


# virtual methods
.method public buildController(Lcom/mobeta/android/dslv/DragSortListView;)Lcom/mobeta/android/dslv/c;
    .locals 2

    .prologue
    .line 47
    new-instance v0, Lcom/mobeta/android/dslv/c;

    invoke-direct {v0, p1}, Lcom/mobeta/android/dslv/c;-><init>(Lcom/mobeta/android/dslv/DragSortListView;)V

    .line 48
    const v1, 0x7f070125

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/c;->b(I)V

    .line 49
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/c;->b(Z)V

    .line 50
    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->sortEnabled:Z

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/c;->a(Z)V

    .line 51
    iget v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->dragStartMode:I

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/c;->a(I)V

    .line 52
    return-object v0
.end method

.method public getController()Lcom/mobeta/android/dslv/c;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mController:Lcom/mobeta/android/dslv/c;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 70
    invoke-super {p0, p1}, Landroid/support/v4/app/ListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 72
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->getListView()Landroid/widget/ListView;

    move-result-object v0

    check-cast v0, Lcom/mobeta/android/dslv/DragSortListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    .line 73
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->onDrop:Lcom/mobeta/android/dslv/i;

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->setDropListener(Lcom/mobeta/android/dslv/i;)V

    .line 74
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 58
    const v0, 0x7f030037

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/mobeta/android/dslv/DragSortListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    .line 60
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->buildController(Lcom/mobeta/android/dslv/DragSortListView;)Lcom/mobeta/android/dslv/c;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mController:Lcom/mobeta/android/dslv/c;

    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mController:Lcom/mobeta/android/dslv/c;

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->setFloatViewManager(Lcom/mobeta/android/dslv/l;)V

    .line 62
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mController:Lcom/mobeta/android/dslv/c;

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 63
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->dragEnabled:Z

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->setDragEnabled(Z)V

    .line 65
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->mDslv:Lcom/mobeta/android/dslv/DragSortListView;

    return-object v0
.end method

.method public setListAdapter()V
    .locals 3

    .prologue
    .line 37
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/SortAdapter;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->ctx:Landroid/content/Context;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->array:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/adapters/SortAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SortAdapter;

    .line 38
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SortAdapter;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 39
    return-void
.end method
