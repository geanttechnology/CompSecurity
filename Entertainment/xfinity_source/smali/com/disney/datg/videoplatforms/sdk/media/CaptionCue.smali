.class public Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
.super Ljava/lang/Object;
.source "CaptionCue.java"


# static fields
.field private static lineSep:Ljava/lang/String;

.field private static timeSep:Ljava/lang/String;


# instance fields
.field private column:I

.field private content:Ljava/lang/String;

.field private endTime:Ljava/lang/String;

.field private indent:I

.field private rawContent:Ljava/lang/String;

.field private row:I

.field private startTime:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 4
    const-string v0, "line.separator"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->lineSep:Ljava/lang/String;

    .line 5
    const-string v0, "-->"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->timeSep:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
    .locals 0
    .param p1, "content"    # Ljava/lang/String;
    .param p2, "startTime"    # Ljava/lang/String;
    .param p3, "endTime"    # Ljava/lang/String;
    .param p4, "row"    # I
    .param p5, "column"    # I
    .param p6, "indent"    # I

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->startTime:Ljava/lang/String;

    .line 17
    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->endTime:Ljava/lang/String;

    .line 18
    iput p4, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->row:I

    .line 19
    iput p5, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->column:I

    .line 20
    iput p6, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->indent:I

    .line 21
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->content:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method protected getHeader()Ljava/lang/String;
    .locals 2

    .prologue
    .line 49
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "WEBVTT"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->lineSep:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->lineSep:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getWebVTT()Ljava/lang/String;
    .locals 3

    .prologue
    .line 54
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 55
    .local v0, "buffer":Ljava/lang/StringBuffer;
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->startTime:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->timeSep:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->endTime:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "line:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->row:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "position:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->column:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v1

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->lineSep:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 56
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->content:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->lineSep:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 57
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method protected setRawText(Ljava/lang/String;)V
    .locals 0
    .param p1, "rawText"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->rawContent:Ljava/lang/String;

    .line 27
    return-void
.end method
