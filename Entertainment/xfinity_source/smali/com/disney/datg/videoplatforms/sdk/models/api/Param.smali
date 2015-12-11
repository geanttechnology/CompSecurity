.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Param;
.super Ljava/lang/Object;
.source "Param.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "param"
    strict = false
.end annotation


# instance fields
.field private attrValue:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "value"
        required = false
    .end annotation
.end field

.field private value:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Text;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAttrValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Param;->attrValue:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Param;->value:Ljava/lang/String;

    return-object v0
.end method
