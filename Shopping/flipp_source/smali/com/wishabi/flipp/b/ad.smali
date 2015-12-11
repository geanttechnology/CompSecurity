.class final Lcom/wishabi/flipp/b/ad;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/location/g;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/ac;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/ac;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/wishabi/flipp/b/ad;->a:Lcom/wishabi/flipp/b/ac;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/location/Location;)V
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Lcom/wishabi/flipp/b/ad;->a:Lcom/wishabi/flipp/b/ac;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    const/4 v1, 0x1

    invoke-static {v0, p1, v1}, Lcom/wishabi/flipp/b/ab;->a(Lcom/wishabi/flipp/b/ab;Landroid/location/Location;I)V

    .line 112
    return-void
.end method
