.class public Lcom/espn/androidplayersdk/objects/EPAuthError;
.super Ljava/lang/Object;
.source "EPAuthError.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x225952976da52fe6L


# instance fields
.field abbrevation:Ljava/lang/String;

.field code:I

.field message:Ljava/lang/String;

.field timeStamp:Ljava/lang/String;

.field type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "timeStamp"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;
    .param p3, "abbrevation"    # Ljava/lang/String;
    .param p4, "type"    # Ljava/lang/String;
    .param p5, "code"    # I

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->timeStamp:Ljava/lang/String;

    .line 19
    iput-object p2, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->message:Ljava/lang/String;

    .line 20
    iput-object p3, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->abbrevation:Ljava/lang/String;

    .line 21
    iput-object p4, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->type:Ljava/lang/String;

    .line 22
    iput p5, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->code:I

    .line 23
    return-void
.end method


# virtual methods
.method public getAbbrevation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->abbrevation:Ljava/lang/String;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getTimeStamp()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->timeStamp:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->type:Ljava/lang/String;

    return-object v0
.end method

.method public geterrorCode()I
    .locals 1

    .prologue
    .line 42
    iget v0, p0, Lcom/espn/androidplayersdk/objects/EPAuthError;->code:I

    return v0
.end method
