.class final Lcom/wishabi/flipp/b/af;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/common/d;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/ab;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/ab;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/wishabi/flipp/b/af;->a:Lcom/wishabi/flipp/b/ab;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/common/a;)V
    .locals 3

    .prologue
    .line 131
    iget-object v0, p0, Lcom/wishabi/flipp/b/af;->a:Lcom/wishabi/flipp/b/ab;

    const/4 v1, 0x0

    const/4 v2, 0x3

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/b/ab;->a(Lcom/wishabi/flipp/b/ab;Landroid/location/Location;I)V

    .line 132
    return-void
.end method
