/*
GNU Lesser General Public License

AlignAction
Copyright (C) 2009 Howard Kistler

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package space.leandragem.ekitten.action;

import java.awt.event.ActionEvent;
import javax.swing.text.StyledEditorKit;

import space.leandragem.ekitten.EkittenCore;

public class AlignAction extends StyledEditorKit.AlignmentAction
{
	protected EkittenCore parent;

	public AlignAction(EkittenCore parent, String actionName, int actionType)
	{
		super(actionName, actionType);
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae)
	{
		int selStart = parent.getTextPane().getSelectionStart();
		int selEnd = parent.getTextPane().getSelectionEnd();
		super.actionPerformed(ae);
		parent.getTextPane().setText(parent.getTextPane().getText());
		parent.getTextPane().setSelectionStart(selStart);
		parent.getTextPane().setSelectionEnd(selEnd);
	}
}