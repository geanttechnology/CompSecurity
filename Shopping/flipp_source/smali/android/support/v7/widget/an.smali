.class public abstract Landroid/support/v7/widget/an;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<VH:",
        "Landroid/support/v7/widget/bi;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field public final a:Landroid/support/v7/widget/ao;

.field public b:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 4068
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4069
    new-instance v0, Landroid/support/v7/widget/ao;

    invoke-direct {v0}, Landroid/support/v7/widget/ao;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    .line 4070
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/an;->b:Z

    return-void
.end method


# virtual methods
.method public abstract a()I
.end method

.method public a(I)I
    .locals 1

    .prologue
    .line 4156
    const/4 v0, 0x0

    return v0
.end method

.method public abstract a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/bi;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TVH;"
        }
    .end annotation
.end method

.method public abstract a(Landroid/support/v7/widget/bi;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;I)V"
        }
    .end annotation
.end method

.method public b(I)J
    .locals 2

    .prologue
    .line 4184
    const-wide/16 v0, -0x1

    return-wide v0
.end method

.method public final b(Landroid/support/v7/widget/bi;I)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;I)V"
        }
    .end annotation

    .prologue
    .line 4134
    iput p2, p1, Landroid/support/v7/widget/bi;->b:I

    .line 4135
    iget-boolean v0, p0, Landroid/support/v7/widget/an;->b:Z

    if-eqz v0, :cond_0

    .line 4136
    invoke-virtual {p0, p2}, Landroid/support/v7/widget/an;->b(I)J

    move-result-wide v0

    iput-wide v0, p1, Landroid/support/v7/widget/bi;->d:J

    .line 4138
    :cond_0
    invoke-virtual {p0, p1, p2}, Landroid/support/v7/widget/an;->a(Landroid/support/v7/widget/bi;I)V

    .line 4139
    const/4 v0, 0x1

    const/4 v1, 0x7

    invoke-virtual {p1, v0, v1}, Landroid/support/v7/widget/bi;->a(II)V

    .line 4141
    return-void
.end method

.method public final c(I)V
    .locals 1

    .prologue
    .line 4353
    iget-object v0, p0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ao;->a(I)V

    .line 4354
    return-void
.end method
