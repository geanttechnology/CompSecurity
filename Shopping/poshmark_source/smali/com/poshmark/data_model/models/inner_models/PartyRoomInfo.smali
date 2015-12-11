.class public Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
.super Ljava/lang/Object;
.source "PartyRoomInfo.java"


# static fields
.field public static final PoshPartyCollectionAllKey:Ljava/lang/String; = "all"

.field public static final PoshPartyCollectionDesignerKey:Ljava/lang/String; = "designer"

.field public static final PoshPartyCollectionFreshKey:Ljava/lang/String; = "fresh"

.field public static final PoshPartyCollectionHostPicksKey:Ljava/lang/String; = "host_picks"

.field public static final PoshPartyCollectionNWTKey:Ljava/lang/String; = "nwt"


# instance fields
.field default_value:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "default"
    .end annotation
.end field

.field description:Ljava/lang/String;

.field id:Ljava/lang/String;

.field name:Ljava/lang/String;

.field posts:I

.field type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCovershotBGColor()I
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "host_picks"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 47
    const v0, 0x7f090010

    .line 59
    :goto_0
    return v0

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "fresh"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    const v0, 0x7f090011

    goto :goto_0

    .line 52
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "designer"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 53
    const v0, 0x7f090012

    goto :goto_0

    .line 55
    :cond_2
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "nwt"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 56
    const v0, 0x7f090013

    goto :goto_0

    .line 59
    :cond_3
    const v0, 0x7f090015

    goto :goto_0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getIconDrawable()I
    .locals 2

    .prologue
    .line 80
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "host_picks"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 81
    const v0, 0x7f0200c3

    .line 93
    :goto_0
    return v0

    .line 83
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "fresh"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 84
    const v0, 0x7f0200c5

    goto :goto_0

    .line 86
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "designer"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 87
    const v0, 0x7f0200c0

    goto :goto_0

    .line 89
    :cond_2
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "nwt"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 90
    const v0, 0x7f0200c7

    goto :goto_0

    .line 93
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPostCount()I
    .locals 1

    .prologue
    .line 42
    iget v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->posts:I

    return v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getWhiteOutlineIconDrawable()I
    .locals 2

    .prologue
    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "host_picks"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    const v0, 0x7f0200c4

    .line 76
    :goto_0
    return v0

    .line 66
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "fresh"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 67
    const v0, 0x7f0200c6

    goto :goto_0

    .line 69
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "designer"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 70
    const v0, 0x7f0200c1

    goto :goto_0

    .line 72
    :cond_2
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->type:Ljava/lang/String;

    const-string v1, "nwt"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 73
    const v0, 0x7f0200c8

    goto :goto_0

    .line 76
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isDefault()Z
    .locals 1

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->default_value:Z

    return v0
.end method
