.class Lcom/poshmark/utils/GestureViewUtils$2;
.super Ljava/lang/Object;
.source "GestureViewUtils.java"

# interfaces
.implements Landroid/animation/TypeEvaluator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/GestureViewUtils;->startTranslationAnimation(Landroid/graphics/Point;Landroid/graphics/Point;Lcom/poshmark/ui/customviews/GestureView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/animation/TypeEvaluator",
        "<",
        "Landroid/graphics/Point;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/GestureViewUtils;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/GestureViewUtils;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/poshmark/utils/GestureViewUtils$2;->this$0:Lcom/poshmark/utils/GestureViewUtils;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public evaluate(FLandroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Point;
    .locals 0
    .param p1, "v"    # F
    .param p2, "start"    # Landroid/graphics/Point;
    .param p3, "end"    # Landroid/graphics/Point;

    .prologue
    .line 83
    return-object p3
.end method

.method public bridge synthetic evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # F
    .param p2, "x1"    # Ljava/lang/Object;
    .param p3, "x2"    # Ljava/lang/Object;

    .prologue
    .line 79
    check-cast p2, Landroid/graphics/Point;

    .end local p2    # "x1":Ljava/lang/Object;
    check-cast p3, Landroid/graphics/Point;

    .end local p3    # "x2":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lcom/poshmark/utils/GestureViewUtils$2;->evaluate(FLandroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Point;

    move-result-object v0

    return-object v0
.end method
