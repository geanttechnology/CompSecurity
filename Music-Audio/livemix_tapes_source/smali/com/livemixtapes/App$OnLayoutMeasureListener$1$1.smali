.class Lcom/livemixtapes/App$OnLayoutMeasureListener$1$1;
.super Ljava/lang/Object;
.source "App.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/App$OnLayoutMeasureListener$1;->onGlobalLayout()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/livemixtapes/App$OnLayoutMeasureListener$1;

.field private final synthetic val$layout:Landroid/view/ViewGroup;


# direct methods
.method constructor <init>(Lcom/livemixtapes/App$OnLayoutMeasureListener$1;Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1$1;->this$2:Lcom/livemixtapes/App$OnLayoutMeasureListener$1;

    iput-object p2, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1$1;->val$layout:Landroid/view/ViewGroup;

    .line 287
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 290
    iget-object v0, p0, Lcom/livemixtapes/App$OnLayoutMeasureListener$1$1;->val$layout:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 291
    return-void
.end method
