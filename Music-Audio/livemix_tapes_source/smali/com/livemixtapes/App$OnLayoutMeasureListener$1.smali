.class Lcom/livemixtapes/App$OnLayoutMeasureListener$1;
.super Ljava/lang/Object;
.source "App.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/App$OnLayoutMeasureListener;-><init>(Landroid/view/ViewGroup;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/App$OnLayoutMeasureListener;

.field private final synthetic val$layout:Landroid/view/ViewGroup;


# direct methods
.method constructor <init>(Lcom/livemixtapes/App$OnLayoutMeasureListener;Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;->this$1:Lcom/livemixtapes/App$OnLayoutMeasureListener;

    iput-object p2, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;->val$layout:Landroid/view/ViewGroup;

    .line 279
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 3

    .prologue
    .line 283
    iget-object v0, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;->val$layout:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 285
    iget-object v0, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;->this$1:Lcom/livemixtapes/App$OnLayoutMeasureListener;

    invoke-virtual {v0}, Lcom/livemixtapes/App$OnLayoutMeasureListener;->onLayoutMeasure()V

    .line 287
    iget-object v0, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;->val$layout:Landroid/view/ViewGroup;

    new-instance v1, Lcom/livemixtapes/App$OnLayoutMeasureListener$1$1;

    iget-object v2, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;->val$layout:Landroid/view/ViewGroup;

    invoke-direct {v1, p0, v2}, Lcom/livemixtapes/App$OnLayoutMeasureListener$1$1;-><init>(Lcom/livemixtapes/App$OnLayoutMeasureListener$1;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->post(Ljava/lang/Runnable;)Z

    .line 293
    return-void
.end method
