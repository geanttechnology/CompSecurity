.class public Lcom/espn/androidplayersdk/objects/EPChannels;
.super Ljava/lang/Object;
.source "EPChannels.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x367e1386e6ffb764L


# instance fields
.field imageSmall:Ljava/lang/String;

.field name:Ljava/lang/String;

.field networkCode:Ljava/lang/String;

.field networkId:Ljava/lang/String;

.field resourceId:Ljava/lang/String;

.field slateImageLarge:Ljava/lang/String;

.field slateImageMed:Ljava/lang/String;

.field slateImageSmall:Ljava/lang/String;

.field type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "id"    # Ljava/lang/String;
    .param p4, "code"    # Ljava/lang/String;
    .param p5, "imageSmall"    # Ljava/lang/String;
    .param p6, "slateImageSmall"    # Ljava/lang/String;
    .param p7, "slateImageMed"    # Ljava/lang/String;
    .param p8, "slateImageLarge"    # Ljava/lang/String;
    .param p9, "resourceId"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->name:Ljava/lang/String;

    .line 23
    iput-object p2, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->type:Ljava/lang/String;

    .line 24
    iput-object p3, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->networkId:Ljava/lang/String;

    .line 25
    iput-object p4, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->networkCode:Ljava/lang/String;

    .line 26
    iput-object p5, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->imageSmall:Ljava/lang/String;

    .line 27
    iput-object p6, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->slateImageSmall:Ljava/lang/String;

    .line 28
    iput-object p7, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->slateImageMed:Ljava/lang/String;

    .line 29
    iput-object p8, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->slateImageLarge:Ljava/lang/String;

    .line 30
    iput-object p9, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->resourceId:Ljava/lang/String;

    .line 31
    return-void
.end method


# virtual methods
.method public getImageSmall()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->imageSmall:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->networkCode:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->networkId:Ljava/lang/String;

    return-object v0
.end method

.method public getResourceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->resourceId:Ljava/lang/String;

    return-object v0
.end method

.method public getSlateImageLarge()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->slateImageLarge:Ljava/lang/String;

    return-object v0
.end method

.method public getSlateImageMed()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->slateImageMed:Ljava/lang/String;

    return-object v0
.end method

.method public getSlateImageSmall()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->slateImageSmall:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPChannels;->type:Ljava/lang/String;

    return-object v0
.end method
