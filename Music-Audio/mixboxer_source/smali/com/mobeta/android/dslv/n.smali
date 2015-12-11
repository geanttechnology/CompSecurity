.class final Lcom/mobeta/android/dslv/n;
.super Landroid/database/DataSetObserver;
.source "SourceFile"


# instance fields
.field private synthetic a:Lcom/mobeta/android/dslv/h;


# direct methods
.method constructor <init>(Lcom/mobeta/android/dslv/h;Lcom/mobeta/android/dslv/DragSortListView;)V
    .locals 0

    .prologue
    .line 648
    iput-object p1, p0, Lcom/mobeta/android/dslv/n;->a:Lcom/mobeta/android/dslv/h;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public final onChanged()V
    .locals 1

    .prologue
    .line 650
    iget-object v0, p0, Lcom/mobeta/android/dslv/n;->a:Lcom/mobeta/android/dslv/h;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/h;->notifyDataSetChanged()V

    .line 651
    return-void
.end method

.method public final onInvalidated()V
    .locals 1

    .prologue
    .line 654
    iget-object v0, p0, Lcom/mobeta/android/dslv/n;->a:Lcom/mobeta/android/dslv/h;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/h;->notifyDataSetInvalidated()V

    .line 655
    return-void
.end method
