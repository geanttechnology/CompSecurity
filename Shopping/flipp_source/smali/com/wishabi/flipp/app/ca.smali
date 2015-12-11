.class final Lcom/wishabi/flipp/app/ca;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/bx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bx;)V
    .locals 0

    .prologue
    .line 254
    iput-object p1, p0, Lcom/wishabi/flipp/app/ca;->a:Lcom/wishabi/flipp/app/bx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 258
    iget-object v0, p0, Lcom/wishabi/flipp/app/ca;->a:Lcom/wishabi/flipp/app/bx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bx;->e(Lcom/wishabi/flipp/app/bx;)Lcom/wishabi/flipp/content/FlyerInfo;

    move-result-object v0

    iget-object v0, v0, Lcom/wishabi/flipp/content/FlyerInfo;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 260
    const-string v1, "locale"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 263
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    .line 265
    iget-object v1, p0, Lcom/wishabi/flipp/app/ca;->a:Lcom/wishabi/flipp/app/bx;

    const-class v2, Lcom/wishabi/flipp/app/fu;

    invoke-static {}, Lcom/wishabi/flipp/app/fu;->b()Lcom/wishabi/flipp/app/fx;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/app/fx;->a(Ljava/lang/String;)Lcom/wishabi/flipp/app/fx;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fx;->a()Lcom/wishabi/flipp/app/fx;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fx;->b()Lcom/wishabi/flipp/app/fx;

    move-result-object v0

    iget-object v0, v0, Lcom/wishabi/flipp/app/fx;->a:Landroid/os/Bundle;

    invoke-virtual {v1, v2, v0}, Lcom/wishabi/flipp/app/bx;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 271
    return-void
.end method
