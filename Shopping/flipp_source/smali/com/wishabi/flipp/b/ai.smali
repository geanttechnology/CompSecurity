.class final Lcom/wishabi/flipp/b/ai;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Landroid/location/Location;

.field final synthetic b:Lcom/wishabi/flipp/b/ah;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/ah;Landroid/location/Location;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/wishabi/flipp/b/ai;->b:Lcom/wishabi/flipp/b/ah;

    iput-object p2, p0, Lcom/wishabi/flipp/b/ai;->a:Landroid/location/Location;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private varargs a()Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 55
    :try_start_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/ai;->b:Lcom/wishabi/flipp/b/ah;

    iget-object v1, v0, Lcom/wishabi/flipp/b/ah;->a:Landroid/location/Geocoder;

    iget-object v0, p0, Lcom/wishabi/flipp/b/ai;->a:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    iget-object v0, p0, Lcom/wishabi/flipp/b/ai;->a:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    const/4 v6, 0x1

    invoke-virtual/range {v1 .. v6}, Landroid/location/Geocoder;->getFromLocation(DDI)Ljava/util/List;

    move-result-object v0

    .line 58
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_0
    move-object v0, v7

    .line 72
    :cond_1
    :goto_0
    return-object v0

    .line 61
    :cond_2
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v0

    .line 62
    if-nez v0, :cond_3

    move-object v0, v7

    .line 63
    goto :goto_0

    .line 65
    :cond_3
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_1

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->isLetter(C)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 67
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " 1A1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 72
    :catch_0
    move-exception v0

    :goto_1
    move-object v0, v7

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_1
.end method


# virtual methods
.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/wishabi/flipp/b/ai;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 51
    check-cast p1, Ljava/lang/String;

    iget-object v0, p0, Lcom/wishabi/flipp/b/ai;->b:Lcom/wishabi/flipp/b/ah;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ah;->b:Lcom/wishabi/flipp/b/ag;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/b/ag;->a(Ljava/lang/String;)V

    return-void
.end method
