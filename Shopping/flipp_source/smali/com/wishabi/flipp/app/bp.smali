.class final Lcom/wishabi/flipp/app/bp;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/wishabi/flipp/widget/bi;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/bo;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bo;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/wishabi/flipp/app/bp;->a:Lcom/wishabi/flipp/app/bo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    .prologue
    .line 138
    check-cast p1, Lcom/wishabi/flipp/widget/bi;

    check-cast p2, Lcom/wishabi/flipp/widget/bi;

    iget-object v0, p1, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->left:F

    iget-object v1, p2, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v1, v1, Landroid/graphics/RectF;->left:F

    invoke-static {v0, v1}, Ljava/lang/Float;->compare(FF)I

    move-result v0

    return v0
.end method
