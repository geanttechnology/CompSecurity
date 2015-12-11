.class final Lcom/exacttarget/etpushsdk/util/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 242
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/util/e;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/exacttarget/etpushsdk/util/e;->b:Ljava/lang/String;

    iput-object p3, p0, Lcom/exacttarget/etpushsdk/util/e;->c:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 244
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/e;->a:Landroid/content/Context;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/util/e;->b:Ljava/lang/String;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/util/d;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/util/e;->c:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    return-void
.end method
