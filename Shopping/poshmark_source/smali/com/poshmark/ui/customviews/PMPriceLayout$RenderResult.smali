.class Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
.super Ljava/lang/Object;
.source "PMPriceLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMPriceLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "RenderResult"
.end annotation


# instance fields
.field endPoint:I

.field renderStartPoint:Landroid/graphics/Point;

.field renderedFontSize:I

.field success:Z

.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMPriceLayout;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMPriceLayout;)V
    .locals 1

    .prologue
    .line 185
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->this$0:Lcom/poshmark/ui/customviews/PMPriceLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 188
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderStartPoint:Landroid/graphics/Point;

    .line 189
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    return-void
.end method
