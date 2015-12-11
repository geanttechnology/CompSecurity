.class Laql$1;
.super Ljava/lang/Object;

# interfaces
.implements Laqi;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laql;-><init>(Landroid/content/Context;Laqm;Laqg;Laru;)V
.end annotation


# instance fields
.field final synthetic a:Laql;


# direct methods
.method constructor <init>(Laql;)V
    .locals 0

    iput-object p1, p0, Laql$1;->a:Laql;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    const-string v0, "event"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Laql$1;->a:Laql;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Laql;->a(Laql;Ljava/lang/String;)V

    :cond_0
    return-void
.end method
