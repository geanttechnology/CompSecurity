.class public final Lcom/wishabi/flipp/widget/bi;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Landroid/graphics/RectF;

.field public final b:F

.field public final c:Ljava/lang/Object;

.field public final d:I

.field private final e:Ljava/lang/String;


# direct methods
.method public constructor <init>(FFFF)V
    .locals 9

    .prologue
    const/4 v6, 0x0

    .line 17
    const/4 v5, 0x0

    const/4 v8, 0x1

    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move-object v7, v6

    invoke-direct/range {v0 .. v8}, Lcom/wishabi/flipp/widget/bi;-><init>(FFFFFLjava/lang/String;Ljava/lang/Object;I)V

    .line 18
    return-void
.end method

.method public constructor <init>(FFFFFLjava/lang/String;Ljava/lang/Object;I)V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, p1, p2, p3, p4}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    .line 34
    iput p5, p0, Lcom/wishabi/flipp/widget/bi;->b:F

    .line 35
    iput-object p6, p0, Lcom/wishabi/flipp/widget/bi;->e:Ljava/lang/String;

    .line 36
    iput-object p7, p0, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    .line 37
    iput p8, p0, Lcom/wishabi/flipp/widget/bi;->d:I

    .line 38
    return-void
.end method


# virtual methods
.method public final a(Z)Landroid/graphics/RectF;
    .locals 2

    .prologue
    .line 77
    if-eqz p1, :cond_0

    .line 78
    new-instance v0, Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    invoke-direct {v0, v1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    .line 80
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    goto :goto_0
.end method

.method public final a(FF)Z
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/RectF;->contains(FF)Z

    move-result v0

    return v0
.end method
