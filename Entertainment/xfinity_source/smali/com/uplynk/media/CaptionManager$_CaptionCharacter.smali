.class Lcom/uplynk/media/CaptionManager$_CaptionCharacter;
.super Ljava/lang/Object;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "_CaptionCharacter"
.end annotation


# instance fields
.field private _char:S

.field private _color:I

.field private _isItalic:Z

.field private _isTransparent:Z

.field private _isUnderlined:Z

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method constructor <init>(Lcom/uplynk/media/CaptionManager;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 914
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 913
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 915
    const/16 v0, 0x20

    iput-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_char:S

    .line 916
    const v0, 0xffffff

    iput v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_color:I

    .line 917
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isItalic:Z

    .line 918
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isUnderlined:Z

    .line 919
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isTransparent:Z

    .line 920
    return-void
.end method


# virtual methods
.method character()S
    .locals 1

    .prologue
    .line 952
    iget-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_char:S

    return v0
.end method

.method color()I
    .locals 1

    .prologue
    .line 953
    iget v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_color:I

    return v0
.end method

.method isItalic()Z
    .locals 1

    .prologue
    .line 954
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isItalic:Z

    return v0
.end method

.method isTransparent()Z
    .locals 1

    .prologue
    .line 956
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isTransparent:Z

    return v0
.end method

.method isUnderlined()Z
    .locals 1

    .prologue
    .line 955
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isUnderlined:Z

    return v0
.end method

.method reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 926
    const/16 v0, 0x20

    iput-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_char:S

    .line 927
    const v0, 0xffffff

    iput v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_color:I

    .line 928
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isItalic:Z

    .line 929
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isUnderlined:Z

    .line 930
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isTransparent:Z

    .line 931
    return-void
.end method

.method setTransparent()V
    .locals 1

    .prologue
    .line 944
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isTransparent:Z

    .line 945
    return-void
.end method

.method setValue(SIZZ)V
    .locals 1
    .param p1, "c"    # S
    .param p2, "color"    # I
    .param p3, "isItalic"    # Z
    .param p4, "isUnderlined"    # Z

    .prologue
    .line 935
    iput-short p1, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_char:S

    .line 936
    iput p2, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_color:I

    .line 937
    iput-boolean p3, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isItalic:Z

    .line 938
    iput-boolean p4, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isUnderlined:Z

    .line 939
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isTransparent:Z

    .line 940
    return-void
.end method

.method toCaptionCharacter(Lcom/uplynk/media/CaptionEvent;)Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    .locals 7
    .param p1, "event"    # Lcom/uplynk/media/CaptionEvent;

    .prologue
    .line 949
    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_char:S

    iget v3, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_color:I

    iget-boolean v4, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isItalic:Z

    iget-boolean v5, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isUnderlined:Z

    iget-boolean v6, p0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->_isTransparent:Z

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;-><init>(Lcom/uplynk/media/CaptionEvent;SIZZZ)V

    return-object v0
.end method
