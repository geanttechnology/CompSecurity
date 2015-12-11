.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;
.super Ljava/lang/Object;
.source "Abcdvas.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "abcdvas"
    strict = false
.end annotation


# instance fields
.field private cvideo:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCvideo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;->cvideo:Ljava/lang/String;

    return-object v0
.end method
