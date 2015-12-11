.class Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;
.super Ljava/lang/Object;
.source "SwipeDismissListViewTouchListener.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PendingDismissData"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;",
        ">;"
    }
.end annotation


# instance fields
.field public position:I

.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

.field public view:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;ILandroid/view/View;)V
    .locals 0
    .param p2, "position"    # I
    .param p3, "view"    # Landroid/view/View;

    .prologue
    .line 229
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 230
    iput p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->position:I

    .line 231
    iput-object p3, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->view:Landroid/view/View;

    .line 232
    return-void
.end method


# virtual methods
.method public compareTo(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;)I
    .locals 2
    .param p1, "other"    # Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;

    .prologue
    .line 237
    iget v0, p1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->position:I

    iget v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->position:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 1
    check-cast p1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;

    invoke-virtual {p0, p1}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->compareTo(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;)I

    move-result v0

    return v0
.end method
