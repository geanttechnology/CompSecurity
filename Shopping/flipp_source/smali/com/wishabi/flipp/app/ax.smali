.class final Lcom/wishabi/flipp/app/ax;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/Loader$OnLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/content/Loader$OnLoadCompleteListener",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlippApplication;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlippApplication;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/wishabi/flipp/app/ax;->a:Lcom/wishabi/flipp/app/FlippApplication;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic onLoadComplete(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/wishabi/flipp/app/ax;->a:Lcom/wishabi/flipp/app/FlippApplication;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlippApplication;->a(Lcom/wishabi/flipp/app/FlippApplication;)V

    return-void
.end method
