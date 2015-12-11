.class public Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissAdapter;
.super Lcom/haarman/listviewanimations/BaseAdapterDecorator;
.source "SwipeDismissAdapter.java"


# instance fields
.field private mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;)V
    .locals 0
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "callback"    # Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;-><init>(Landroid/widget/BaseAdapter;)V

    .line 35
    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissAdapter;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    .line 36
    return-void
.end method


# virtual methods
.method public setListView(Landroid/widget/ListView;)V
    .locals 2
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 40
    invoke-super {p0, p1}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->setListView(Landroid/widget/ListView;)V

    .line 41
    new-instance v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissAdapter;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    invoke-direct {v0, p1, v1}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;-><init>(Landroid/widget/ListView;Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;)V

    invoke-virtual {p1, v0}, Landroid/widget/ListView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 42
    return-void
.end method
