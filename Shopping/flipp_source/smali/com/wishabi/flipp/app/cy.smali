.class final Lcom/wishabi/flipp/app/cy;
.super Lcom/wishabi/flipp/b/al;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cx;JLjava/lang/String;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 323
    iput-object p1, p0, Lcom/wishabi/flipp/app/cy;->a:Lcom/wishabi/flipp/app/cx;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/wishabi/flipp/b/al;-><init>(JLjava/lang/String;Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 323
    check-cast p1, Lcom/wishabi/flipp/content/af;

    iget-object v0, p0, Lcom/wishabi/flipp/app/cy;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/cx;->a(Lcom/wishabi/flipp/app/cx;Lcom/wishabi/flipp/content/af;)V

    return-void
.end method
