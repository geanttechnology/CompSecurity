.class Laql$3;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/ComponentCallbacks2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laql;->b()V
.end annotation


# instance fields
.field final synthetic a:Laql;


# direct methods
.method constructor <init>(Laql;)V
    .locals 0

    iput-object p1, p0, Laql$3;->a:Laql;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0

    return-void
.end method

.method public onLowMemory()V
    .locals 0

    return-void
.end method

.method public onTrimMemory(I)V
    .locals 1

    const/16 v0, 0x14

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Laql$3;->a:Laql;

    invoke-virtual {v0}, Laql;->a()V

    :cond_0
    return-void
.end method
