.class final Landroid/support/v4/app/ae;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/app/ag;


# instance fields
.field final synthetic a:Landroid/support/v4/app/ac;


# direct methods
.method constructor <init>(Landroid/support/v4/app/ac;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Landroid/support/v4/app/ae;->a:Landroid/support/v4/app/ac;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)Landroid/view/View;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Landroid/support/v4/app/ae;->a:Landroid/support/v4/app/ac;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/ac;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Landroid/support/v4/app/ae;->a:Landroid/support/v4/app/ac;

    invoke-virtual {v0}, Landroid/support/v4/app/ac;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 115
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/Window;->peekDecorView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
