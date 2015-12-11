.class public final Lcom/wishabi/flipp/app/fx;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Landroid/os/Bundle;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/fx;->a:Landroid/os/Bundle;

    .line 38
    return-void
.end method

.method synthetic constructor <init>(B)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/wishabi/flipp/app/fx;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()Lcom/wishabi/flipp/app/fx;
    .locals 3

    .prologue
    .line 46
    iget-object v0, p0, Lcom/wishabi/flipp/app/fx;->a:Landroid/os/Bundle;

    const-string v1, "enable_zoom"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 47
    return-object p0
.end method

.method public final a(Ljava/lang/String;)Lcom/wishabi/flipp/app/fx;
    .locals 2

    .prologue
    .line 41
    iget-object v0, p0, Lcom/wishabi/flipp/app/fx;->a:Landroid/os/Bundle;

    const-string v1, "url"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    return-object p0
.end method

.method public final b()Lcom/wishabi/flipp/app/fx;
    .locals 3

    .prologue
    .line 56
    iget-object v0, p0, Lcom/wishabi/flipp/app/fx;->a:Landroid/os/Bundle;

    const-string v1, "fit_to_width"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 57
    return-object p0
.end method
