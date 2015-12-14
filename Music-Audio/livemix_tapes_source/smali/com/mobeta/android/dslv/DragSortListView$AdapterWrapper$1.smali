.class Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper$1;
.super Landroid/database/DataSetObserver;
.source "DragSortListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;-><init>(Lcom/mobeta/android/dslv/DragSortListView;Landroid/widget/ListAdapter;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;


# direct methods
.method constructor <init>(Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper$1;->this$1:Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;

    .line 648
    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 650
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper$1;->this$1:Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;->notifyDataSetChanged()V

    .line 651
    return-void
.end method

.method public onInvalidated()V
    .locals 1

    .prologue
    .line 654
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper$1;->this$1:Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/DragSortListView$AdapterWrapper;->notifyDataSetInvalidated()V

    .line 655
    return-void
.end method
