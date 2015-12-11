.class final Lcom/wishabi/flipp/app/bq;
.super Lcom/wishabi/flipp/b/am;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/bo;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bo;Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 266
    iput-object p1, p0, Lcom/wishabi/flipp/app/bq;->a:Lcom/wishabi/flipp/app/bo;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/wishabi/flipp/b/am;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/wishabi/flipp/app/bq;->a:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;)Z

    iget-object v0, p0, Lcom/wishabi/flipp/app/bq;->a:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->b(Lcom/wishabi/flipp/app/bo;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/bq;->a:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->c()V

    return-void
.end method
