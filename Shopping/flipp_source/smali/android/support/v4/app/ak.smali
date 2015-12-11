.class final Landroid/support/v4/app/ak;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:I

.field final synthetic b:I

.field final synthetic c:Landroid/support/v4/app/ai;


# direct methods
.method constructor <init>(Landroid/support/v4/app/ai;I)V
    .locals 1

    .prologue
    .line 526
    iput-object p1, p0, Landroid/support/v4/app/ak;->c:Landroid/support/v4/app/ai;

    iput p2, p0, Landroid/support/v4/app/ak;->a:I

    const/4 v0, 0x1

    iput v0, p0, Landroid/support/v4/app/ak;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .prologue
    .line 528
    iget-object v0, p0, Landroid/support/v4/app/ak;->c:Landroid/support/v4/app/ai;

    iget-object v1, p0, Landroid/support/v4/app/ak;->c:Landroid/support/v4/app/ai;

    iget-object v1, v1, Landroid/support/v4/app/ai;->o:Landroid/support/v4/app/ac;

    iget v1, p0, Landroid/support/v4/app/ak;->a:I

    iget v2, p0, Landroid/support/v4/app/ak;->b:I

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/ai;->a(II)Z

    .line 529
    return-void
.end method
