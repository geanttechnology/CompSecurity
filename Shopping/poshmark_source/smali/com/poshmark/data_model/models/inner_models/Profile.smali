.class public Lcom/poshmark/data_model/models/inner_models/Profile;
.super Ljava/lang/Object;
.source "Profile.java"


# instance fields
.field public city:Ljava/lang/String;

.field public dress_size:Ljava/lang/String;

.field public shoe_size:Ljava/lang/String;

.field public state:Ljava/lang/String;

.field public website:Ljava/lang/String;

.field public zip:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLocation()Ljava/lang/String;
    .locals 2

    .prologue
    .line 14
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 15
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 24
    :goto_0
    return-object v0

    .line 17
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 18
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    goto :goto_0

    .line 20
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_2

    .line 21
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    goto :goto_0

    .line 24
    :cond_2
    const-string v0, ""

    goto :goto_0
.end method
