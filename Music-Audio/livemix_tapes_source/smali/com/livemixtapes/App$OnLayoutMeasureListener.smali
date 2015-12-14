.class public abstract Lcom/livemixtapes/App$OnLayoutMeasureListener;
.super Ljava/lang/Object;
.source "App.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/App;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "OnLayoutMeasureListener"
.end annotation


# instance fields
.field private final layout:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>(Landroid/view/ViewGroup;)V
    .locals 2
    .param p1, "layout"    # Landroid/view/ViewGroup;

    .prologue
    .line 274
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 275
    iput-object p1, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener;->layout:Landroid/view/ViewGroup;

    .line 277
    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 279
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;

    invoke-direct {v1, p0, p1}, Lcom/livemixtapes/App$OnLayoutMeasureListener$1;-><init>(Lcom/livemixtapes/App$OnLayoutMeasureListener;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 295
    return-void
.end method


# virtual methods
.method public abstract onLayoutMeasure()V
.end method
