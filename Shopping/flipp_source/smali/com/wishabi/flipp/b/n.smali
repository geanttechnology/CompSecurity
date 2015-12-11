.class final Lcom/wishabi/flipp/b/n;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/net/URL;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/wishabi/flipp/b/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/a;Ljava/net/URL;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1035
    iput-object p1, p0, Lcom/wishabi/flipp/b/n;->c:Lcom/wishabi/flipp/b/a;

    iput-object p2, p0, Lcom/wishabi/flipp/b/n;->a:Ljava/net/URL;

    iput-object p3, p0, Lcom/wishabi/flipp/b/n;->b:Ljava/lang/String;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 1035
    iget-object v0, p0, Lcom/wishabi/flipp/b/n;->a:Ljava/net/URL;

    iget-object v1, p0, Lcom/wishabi/flipp/b/n;->b:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/net/URL;Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method
